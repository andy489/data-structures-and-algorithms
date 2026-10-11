// https://www.hackerrank.com/contests/sda-2019-2020-test3/challenges/print-specific-level

#include <iostream>

using namespace std;

struct Node {
    Node *left;
    Node *right;
    int value;

    Node(int value) {
        this->value = value;
        this->left = nullptr;
        this->right = nullptr;
    }
};

class BST {

public:
    BST() {
        root = nullptr;
    }

    void insert(int value) {
        root = insert(root, value);
    }

    void print(Node *root, int k, int currLevel) {
        if (root == nullptr) {
            return;
        }

        print(root->right, k, currLevel + 1);

        if (currLevel == k) {
            cout << root->value << ' ';
        }

        print(root->left, k, currLevel + 1);
    }

    void print_k_distant(int k) {
        print(root, k, 0);
    }

private:
    //you can write helper functions if needed
    Node *root;

    Node *insert(Node *curr_node, int value) {
        if (curr_node == nullptr) {
            curr_node = new Node(value);
        } else if (curr_node->value < value) {
            curr_node->right = insert(curr_node->right, value);
        } else if (curr_node->value > value) {
            curr_node->left = insert(curr_node->left, value);
        } else {
            // if we already have this value at the tree - do nothing
        }

        return curr_node;
    }
};

int main() {
    int n;
    cin >> n;
    
    BST tree;

    int value;
    for (int i = 0; i < n; i++) {
        cin >> value;
        tree.insert(value);
    }

    int k;
    cin >> k;

    tree.print_k_distant(k);

    return 0;
}
