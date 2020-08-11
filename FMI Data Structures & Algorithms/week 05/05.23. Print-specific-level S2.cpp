// github.com/andy489

// https://www.hackerrank.com/contests/sda-2019-2020-test3/challenges/print-specific-level

#include <iostream>
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

    void print(Node *root, int k, int currLevel) {
        if (root == nullptr)
            return;
        print(root->right, k, currLevel + 1);
        if (currLevel == k)
            cout << root->value << ' ';
        print(root->left, k, currLevel + 1);
    }

    void printKDistant(int k) {
        print(root, k, 0);
    }

private:
    //you can write helper functions if needed
    Node *root;

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
    int n, value, i(0), k;
    cin >> n;
    BST tree;
    for (; i < n; i++) {
        cin >> value;
        tree.insert(value);
    }
    cin >> k;
    return tree.printKDistant(k), 0;
}
