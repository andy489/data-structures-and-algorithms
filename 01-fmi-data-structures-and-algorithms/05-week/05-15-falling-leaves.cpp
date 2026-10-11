// https://www.hackerrank.com/contests/test4-sda-/challenges/challenge-1692

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
        if (root == nullptr)
            return new Node(data);
        else {
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

    void leaves_odd(Node *root) {
        if (root->left_node == nullptr && root->right_node == nullptr) {
            if (root->data & 1) { // odd
                sum += root->data;
            }

            return;
        }
        if (root->left_node) {
            leaves_odd(root->left_node);
        }
        if (root->right_node) {
            leaves_odd(root->right_node);
        }
    }

    void leaves(Node *root) {
        leaves_odd(root);
        cout << sum << endl;
    }

private:
    int sum = 0;
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

    my_tree.leaves(root);

    return 0;
}
