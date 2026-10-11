// https://www.hackerrank.com/contests/test4-sda-/challenges/challenge-1691/problem

#include <iostream>

using namespace std;

class Node {
public:
    int data;
    Node *left_node;
    Node *right_node;

    explicit Node(int d) {
        data = d;
        left_node = nullptr;
        right_node = nullptr;
    }
};

class Solution {
public:
    Node *insert(Node *root, int data) {
        if (root == nullptr) {
            return new Node(data);
        } else {
            Node *cur;
            if (data <= root->data) {
                cur = insert(root->left_node, data);
                root->left_node = cur;
            } else {
                cur = insert(root->right_node, data);
                root->right_node = cur;
            }

            return root;
        }
    }

    void print(Node *root, bool is_root = true) {
        if (root) {
            print(root->right_node, false);
            print(root->left_node, false);

            if (is_root) {
                cout << root->data;
            } else {
                cout << root->data << ';';
            }
        }
    }
};

int main() {
    Solution my_tree;
    Node *root = nullptr;

    int t, data;
    cin >> t;

    while (t--) {
        cin >> data;
        root = my_tree.insert(root, data);
    }

    my_tree.print(root);

    return 0;
}
