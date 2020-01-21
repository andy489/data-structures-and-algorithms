//https://www.hackerrank.com/contests/sda-2019-2020-test3/challenges/penultimate-descendants
#include <iostream>
using namespace std;

struct Node
{
    Node* l = nullptr, * r = nullptr;
    int data;
    Node(int data) :data(data) {}
};

Node* add(Node* root, int a)
{
    if (root == nullptr) return new Node(a);
    else if (a > root->data) root->r = add(root->r, a);
    else if (a < root->data) root->l = add(root->l, a);
    return root;
}

bool isLeaf(Node* node)
{
    if (node == nullptr) return false;
    return node->l == nullptr && node->r == nullptr;
}

Node* pre_leaf_del(Node* root)
{
    if (root == nullptr) return root;
    else if (isLeaf(root->l) && isLeaf(root->r))
    {
        Node* tmp = root;
        root = root->r;
        root->l = tmp->l;
        delete tmp;
    }
    else if (isLeaf(root->l) && root->r == nullptr)
    {
        Node* tmp = root;
        root = root->l;
        delete tmp;
    }
    else if (isLeaf(root->r) && root->l == nullptr)
    {
        Node* tmp = root;
        root = root->r;
        delete tmp;
    }
    else
    {
        root->r = pre_leaf_del(root->r);
        root->l = pre_leaf_del(root->l);
    }
    return root;
}

void LDR(Node* root)
{
    if (root)
    {
        LDR(root->l);
        cout << root->data << ' ';
        LDR(root->r);
    }
}
Node* root;
int main()
{
    int n, a;
    cin >> n;
    while (n--)
    {
        cin >> a;
        root = add(root, a);
    }
    root = pre_leaf_del(root);
    LDR(root);
    return 0;
}
