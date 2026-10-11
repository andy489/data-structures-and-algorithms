// https://www.hackerrank.com/contests/sda-2019-2020-test3/challenges/penultimate-descendants

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

    void delete_penultimate_and_print() {
        root = remove(root);
        print(root);
    }

private:
    static bool is_leaf(Node *root) {
        if (root == nullptr) {
            return false;
        }

        return !root->left && !root->right;
    }

    Node *remove(Node *root) {
        if (root == nullptr || is_leaf(root)) {
            return root;
        }

        if (is_leaf(root->left) && root->right == nullptr) {
            Node *tmp = root;

            root = root->left;

            delete tmp;

            return root;
        } else if (root->left == nullptr && is_leaf(root->right)) {
            Node *tmp = root;

            root = root->right;

            delete tmp;

            return root;
        } else {
            if (is_leaf(root->left) && is_leaf(root->right)) {
                Node *tmp = root;

                root = root->right;
                root->left = tmp->left;

                delete tmp;

                return root;
            } else {
                root->left = remove(root->left);
                root->right = remove(root->right);
            }
        }
        return root;
    }

    void print(Node *root) {
        if (root) {
            print(root->left);
            cout << root->value << " ";
            print(root->right);
        }
    }

    Node *root;

    Node *insert(Node *curNode, int value) {
        if (curNode == nullptr) {
            curNode = new Node(value);
        } else if (curNode->value < value) {
            curNode->right = insert(curNode->right, value);
        } else if (curNode->value > value) {
            curNode->left = insert(curNode->left, value);
        } else {
            // if we already have this value at the tree - do nothing
        }
        return curNode;
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

    tree.delete_penultimate_and_print();

    return 0;
}
