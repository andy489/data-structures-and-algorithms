// github.com/andy489

// https://www.hackerrank.com/contests/sda-2019-2020-test3/challenges/penultimate-descendants

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Node {
    Node *left;
    Node *right;
    int value;

    Node(int value) {
        this->value = value;
        this->left = NULL;
        this->right = NULL;
    }
};

class BST {

public:
    BST() {
        root = NULL;
    }

    void insert(int value) {
        root = insert(root, value);
    }

    void deletePenultimateAndPrint() {
        vector<int> v;
        queue<Node *> q;
        q.push(root);
        while (!q.empty()) {
            Node *a = q.front();
            q.pop();
            if (a->left != nullptr || a->right != nullptr) {
                if (a->left && a->right) {
                    if (a->left->left == nullptr && a->left->right == nullptr && a->right->left == nullptr &&
                        a->right->right == nullptr) {
                        v.push_back(a->value);
                    }
                } else {
                    if (a->left) {
                        if (a->left->left == nullptr && a->left->right == nullptr)
                            v.push_back(a->value);
                    } else
                        if (a->right->left == nullptr && a->right->right == nullptr) {
                            v.push_back(a->value);
                    }
                }
            }
            if (a->left)
                q.push(a->left);
            if (a->right)
                q.push(a->right);
        }
        int i(0), s(v.size());
        for (; i < s; ++i)
            remove(root, v[i]);
        print(root);
    }

private:
    //you can write helper functions if needed
    Node *root;

    void print(Node *r) {
        if (r) {
            print(r->left);
            cout << r->value << " ";
            print(r->right);
        }
    }

    Node *remove(Node *r, int v) {
        if (r == nullptr)
            return nullptr;
        if (v > r->value)
            r->right = remove(r->right, v);
        else {
            if (v < r->value)
                r->left = remove(r->left, v);
            else {
                if (r->left == nullptr) {
                    Node *temp = r->right;
                    delete r;
                    return temp;
                }
                Node *sw = r->left;
                while (sw->right)
                    sw = sw->right;
                r->value = sw->value;
                r->left = remove(r->left, r->value);
            }
        }
        return r;
    }

    Node *insert(Node *curNode, int value) {
        if (curNode == NULL)
            curNode = new Node(value);
        else if (curNode->value < value)
            curNode->right = insert(curNode->right, value);
        else if (curNode->value > value)
            curNode->left = insert(curNode->left, value);
        else {
            //if we already have this value at the tree - do nothing
        }
        return curNode;
    }
};

int main() {
    int n, value, i(0);
    cin >> n;
    BST tree;
    for (; i < n; ++i) {
        cin >> value;
        tree.insert(value);
    }
    return tree.deletePenultimateAndPrint(), 0;
}
