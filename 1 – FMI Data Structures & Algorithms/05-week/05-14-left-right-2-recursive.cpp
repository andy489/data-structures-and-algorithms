// https://www.hackerrank.com/contests/test4-sda-/challenges/left-right-2/problem

#include <cstdio>

using namespace std;

class Node {
public:
    int data;
    Node *left_node;
    Node *right_node;

    Node(int d) {
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

    void left_right_cnt(Node *root, int &left, int &right) {
        if (root == nullptr) {
            return;
        }
        if (root->left_node) {
            ++left;
            left_right_cnt(root->left_node, left, right);
        }
        if (root->right_node) {
            ++right;
            left_right_cnt(root->right_node, left, right);
        }
    }

    void left_right(Node *root) {
        int left = 0;
        int right = 0;
        
        left_right_cnt(root, left, right);
        
        printf("[%d,%d]", left, right);
    }
};

int main() {
    Solution my_tree;
    Node *root = nullptr;

    int t, data;
    scanf("%d", &t);

    while (t--) {
        scanf("%d", &data);
        root = my_tree.insert(root, data);
    }

    my_tree.left_right(root);

    return 0;
}
