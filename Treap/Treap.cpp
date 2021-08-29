#include <cstdio>     // printf(..)
#include <cstdlib>    // rand(..)
#include <ctime>      // time(..)
#include <algorithm>  // swap(..)

using namespace std;

struct Node {
    int key, prior, cnt;
    Node *l, *r;

    Node() {}

    Node(int key) : key(key), prior(rand()), l(nullptr), r(nullptr) {}
};

typedef Node *pnode;

struct Treap {
private:
    pnode root;

    void split(pnode t, int key, pnode &l, pnode &r) {  // O(log(N))
        if (!t) l = r = nullptr;  // base case
        else if (t->key <= key) // traverse right
            split(t->r, key, t->r, r), l = t;
        else  // traverse left
            split(t->l, key, l, t->l), r = t;
    }

    void merge(pnode &t, pnode l, pnode r) {  // O(log(N))
        if (!l || !r) t = l ? l : r;  // base case
        else if (l->prior <= r->prior)  // get right node and traverse left from right treap
            merge(r->l, l, r->l), t = r;
        else  // get left node and traverse right from left treap
            merge(l->r, l->r, r), t = l;
    }

    void insertUtil(pnode &t, pnode it) { // O(log(N))
        if (!t) t = it; // base case
        else if (it->prior <= t->prior) // traverse left or right sub-treaps according to t->key
            insertUtil(t->key <= it->key ? t->r : t->l, it);
        else  // we found the place where we must insert the node it, so split t and adjust the result of split to children of t.
            split(t, it->key, it->l, it->r), t = it;
    }

    void eraseUtil(pnode &t, int key) { // O(log(N))
        if (!t) return; // if we reached an empty node - do nothing (when we try to erase a missing item)
        if (t->key == key) {  // we find the node that we want to erase
            pnode temp = t; // take the node to erase
            merge(t, t->l, t->r); // merge the left and right sub-treaps of the node to be erased (t points to one of t->l or t->r)
            delete temp;  // delete the node
        } else eraseUtil(key <= t->key ? t->l : t->r, key); // traverse to left or right sub-treaps of t, according to key (BST-like traversal)
    }

      int cnt(pnode t) {// O(1)
        return t ? t->cnt : 0;
    }

    void upd_cnt(pnode t) { // O(1)
        if (t)  // assumes that cnt(t->l) and cnt(t->r) are already calculated
            t->cnt = 1 + cnt(t->l) + cnt(t->r);
    }


    void heapify(pnode t) { // O(hight(t))
        if (!t) return;
        pnode max = t;
        if (t->l != nullptr && t->l->prior > max->prior)
            max = t->l;
        if (t->r != nullptr && t->r->prior > max->prior)
            max = t->r;
        if (t != max) {
            swap(t->prior, max->prior);
            heapify(max);
        }
    }

    pnode buildUtil(int *a, int n) {  // O(n) on average: 0*n/2+1*n/4+...+h*1 = sum_{k=1}^{h}\frac{kn}{2^{k+1}}
        if (n == 0) // base case
            return nullptr;
        int mid = n / 2;
        pnode t = new Node(a[mid]); // make middle item root node
        t->l = buildUtil(a, mid); 
        t->r = buildUtil(a + mid + 1, n - mid - 1);
        heapify(t);
        upd_cnt(t);
        return t;
    }
    
    pnode uniteUtil(pnode l, pnode r) { // O(N*log(N/M))
        if (!l || !r)   // base case
            return l ? l : r;
        if (l->prior < r->prior)    // guarantee that l->prior >= r->prior
            swap(l, r);
        pnode lt, rt;
        split(r, l->key, lt, rt);   // split the treap with lower prior in root into lt and rt
        l->l = uniteUtil(l->l, lt); // combine l->l and lt
        l->r = uniteUtil(l->r, rt); // combine l->r and rt
        return l;
    }

    void LDRutil(pnode s) { // simple LDR traversal (used as print function)
        if (!s) return;
        LDRutil(s->l);
        printf("%d %d\n", s->key, s->prior);
        LDRutil(s->r);
    }

public:
    Treap() : root(nullptr) {}

    pnode getRoot(){
        return this->root;
    }
    
    void insert(pnode it) {
        insertUtil(this->root, it);
    }

    void erase(int key) {
        eraseUtil(this->root, key);
    }

    void build(int *a, int n) {
        root = buildUtil(a, n);
    }

    void unite(pnode t){
        this->root = uniteUtil(this->root, t);
    }
    
    void LDR() {
        LDRutil(this->root);
    }
};

int main() {
     srand(time(nullptr));

    Treap T1, T2, T3;
    int *a = new int[10];

    for (int i = 0; i < 10; ++i) {
        pnode n = new Node(i);
        a[i] = i;
        T1.insert(n);
    }

    T1.LDR();
    T2.build(a, 10);
    T2.LDR();

    T1.erase(2);
    T2.erase(2);

    T1.LDR();
    T2.LDR();

    for (int i = 10; i < 20; ++i) {
        pnode n = new Node(i);
        T3.insert(n);
    }

    T1.unite(T3.getRoot());
    T1.LDR();
    return 0;
}
