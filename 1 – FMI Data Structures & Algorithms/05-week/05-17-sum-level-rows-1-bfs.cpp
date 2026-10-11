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

    void sumLevel(Node *root) {
        if (root == nullptr) {
            return;
        }

        queue<Node *> q;
        q.push(root);

        c = 1;
        sumPerRow = root->data;

        while (!q.empty()) {
            cout << sumPerRow;
            sumPerRow = 0;

            while (c--) {
                Node *curr = q.front();
                q.pop();
                if (curr->left_node) {
                    q.push(curr->left_node);
                    sumPerRow += curr->left_node->data;
                }
                if (curr->right_node) {
                    q.push(curr->right_node);
                    sumPerRow += curr->right_node->data;
                }
            }

            c = q.size();

            if (c) {
                cout << ';';
            }
        }
    }

private:
    int c, sumPerRow;
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

    my_tree.sumLevel(root);

    return 0;
}
