// https://www.hackerrank.com/contests/sda-2019-2020-test3/challenges/tree-specific-print

#include <iostream>

using namespace std;

struct Node {
    Node *left;
    Node *right;
    int value;

    explicit Node(int value) {
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

    void DLR(Node *root, int divided_by) {
        if (!root) {
            return;
        }
        
        if (root->value % divided_by == 0 && (root->left != nullptr || root->right != nullptr)) {
            cout << root->value << ' ';
        }
        
        DLR(root->left, divided_by);
        DLR(root->right, divided_by);
    }

    void printSpecific(int divided_by) {
        DLR(root, divided_by);
    }

private:
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
    for (int i = 0; i < n; ++i) {
        cin >> value;
        tree.insert(value);
    }

    int divide_by;
    cin >> divide_by;

    tree.printSpecific(divide_by);

    return 0;
}
