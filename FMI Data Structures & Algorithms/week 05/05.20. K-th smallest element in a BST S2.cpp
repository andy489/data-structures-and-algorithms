// github.com/andy489

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

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
    int kthSmallest(TreeNode *root, int k) {
        if (root->left->size == k - 1)
            return root->data;
        else if (root->left->size > k - 1)
            return kthSmallest(root->left, k);
        else
            return kthSmallest(root->right, k - root->size - 1);
    }
};
