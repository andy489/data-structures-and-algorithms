// https://www.hackerrank.com/contests/test4-sda-/challenges/challenge-1693/problem

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

    void count(Node *root) {
        if (root == nullptr) {
            return;
        }

        queue<Node *> q;
        q.push(root);
        c = 1;

        while (!q.empty()) {
            cout << q.size();

            while (c--) {
                Node *curr = q.front();
                q.pop();

                if (curr->left_node) {
                    q.push(curr->left_node);
                }

                if (curr->right_node) {
                    q.push(curr->right_node);
                }
            }

            c = q.size();

            if (c) {
                cout << ';';
            }
        }
    }

private:
    int c;
};

int main() {
    Solution my_tree{};
    Node *root = nullptr;

    int t, data;
    cin >> t;

    while (t--) {
        cin >> data;
        root = my_tree.insert(root, data);
    }

    my_tree.count(root);

    return 0;
}
