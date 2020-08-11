// github.com/andy489

// https://leetcode.com/problems/delete-node-in-a-bst/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int getMax(TreeNode *root) {
        TreeNode *current = root;
        while (current->right) 
            current = current->right;
        return current->val;
    }

    TreeNode *deleteNode(TreeNode *root, int key) {
        if (root == nullptr)
            return root;
        if (key < root->val)
            root->left = deleteNode(root->left, key);
        else if (key > root->val)
            root->right = deleteNode(root->right, key);
        else {
            if (root->left == nullptr) {
                TreeNode *toReturn = root->right;
                delete root;
                return toReturn;
            } else if (root->right == nullptr) {
                TreeNode *toReturn = root->left;
                delete root;
                return toReturn;
            } else {
                int toReplace = getMax(root->left);
                root->val = toReplace;
                root->left = deleteNode(root->left, toReplace);
            }
        }
        return root;
    }
};
