#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
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
        root = remove(root);
        print(root);
    }

private:
    //you can write helper functions if needed

    bool isLeaf(Node* root)
    {
        if (root == nullptr)
            return 0;
        return !root->left && !root->right;
    }

    Node* remove(Node* root)
    {
        if (root == nullptr || isLeaf(root))
            return root;

        if (isLeaf(root->left) && root->right == nullptr)
        {
            Node* tmp = root;
            root = root->left;
            delete tmp;
            return root;
        }
        else if (root->left == nullptr && isLeaf(root->right))
        {
            Node* tmp = root;
            root = root->right;
            delete tmp;
            return root;
        }
        else
        {
            if (isLeaf(root->left) && isLeaf(root->right))
            {
                Node* tmp = root;
                root = root->right;
                root->left = tmp->left;
                delete tmp;
                return root;
            }
            else
            {
                root->left = remove(root->left);
                root->right = remove(root->right);
            }
        }
        return root;
    }

    void print(Node* root)
    {
        if (root)
        {
            print(root->left);
            cout << root->value << " ";
            print(root->right);
        }
    }

    Node* root;

    Node* insert(Node *curNode, int value) {
        if (curNode == NULL) {
            curNode = new Node(value);
        }
        else if (curNode->value < value) {
            curNode->right = insert(curNode->right, value);
        }
        else if (curNode->value > value) {
            curNode->left = insert(curNode->left, value);
        }
        else {
            //if we already have this value at the tree - do nothing
        }
        return curNode;
    }
};

int main() {
    int n;
    cin >> n;
    int value;
    BST tree;
    for (int i = 0; i < n; i++) {
        cin >> value;
        tree.insert(value);
    }
    tree.deletePenultimateAndPrint();
    return 0;
}
