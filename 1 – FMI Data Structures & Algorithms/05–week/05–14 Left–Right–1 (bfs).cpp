// https://www.hackerrank.com/contests/test4-sda-/challenges/left-right-2/problem

#include <iostream>
#include <queue>

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

    void left_right(Node *root) {
        queue<Node *> q;
        q.push(root);

        while (!q.empty()) {
            Node *top = q.front();

            if (top->left_node != nullptr) {
                ++left_cnt;
                q.push(top->left_node);
            }

            if (top->right_node != nullptr) {
                ++right_cnt;
                q.push(top->right_node);
            }

            q.pop();
        }
        cout << "[" << left_cnt << "," << right_cnt << "]\n";
    }

private:
    int left_cnt = 0;
    int right_cnt = 0;
}; 

int main() {
    Solution my_tree;
    Node *root = nullptr;

    int t;
    cin >> t;
    
    int data;
    while (t--) {
        cin >> data;
        root = my_tree.insert(root, data);
    }

    my_tree.left_right(root);

    return 0;
}
