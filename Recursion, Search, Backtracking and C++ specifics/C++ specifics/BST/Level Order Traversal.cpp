// https://www.hackerrank.com/challenges/30-binary-search-trees/problem

#include <iostream>
#include <queue>
#include <string>

using namespace std;

class Node {
public:
    int data;
    Node *left, *right;

    explicit Node(int d) {
        data = d;
        left = right = nullptr;
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
                cur = insert(root->left, data);
                root->left = cur;
            } else {
                cur = insert(root->right, data);
                root->right = cur;
            }
            return root;
        }
    }

    void levelOrder(Node *root) {
        if (root == nullptr) return;
        queue<Node *> q;
        q.push(root);

        while (!q.empty()) {
            int s = q.size();
            while (s--) {
                Node *curr = q.front();
                q.pop();
                if (curr->left) q.push(curr->left);
                if (curr->right) q.push(curr->right);
                cout << curr->data << ' ';
            }
        }
    }
};//End of Solution

int main() {
    Solution myTree;
    Node *root = nullptr;

    int T, data;

    cin >> T;
    while (T-- > 0) {
        cin >> data;
        root = myTree.insert(root, data);
    }

    myTree.levelOrder(root);
    return 0;
}
