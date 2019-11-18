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
private:
    bool isSymmetric(TreeNode* lhs, TreeNode* rhs) {
        if (!lhs && !rhs) {
            return true;
        }
       
        if (!lhs || !rhs) {
            return false;
        }
       
        return (lhs->val) == (rhs->val) && isSymmetric(lhs->left, rhs->right) && isSymmetric(lhs->right, rhs->left);
    }
   
public:
    bool isSymmetric(TreeNode* root) {
        return isSymmetric(root, root);
    }
};
