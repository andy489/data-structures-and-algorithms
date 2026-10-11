// https://leetcode.com/problems/maximum-depth-of-binary-tree/

/*
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }

        return max(maxDepth(root->left), maxDepth(root->right)) + 1;
    }
};
*/


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

    int depth(Node *root) {
        if (root == nullptr) {
            return -1;
        }

        return max(depth(root->left_node), depth(root->right_node)) + 1;
    }
};

int main() {
    Solution myTree{};
    Node *root = nullptr;

    int t, data;
    cin >> t;

    while (t--) {
        cin >> data;
        root = myTree.insert(root, data);
    }

    cout << myTree.depth(root);

    return 0;
}
