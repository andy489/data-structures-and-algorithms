// https://leetcode.com/problems/root-equals-sum-of-children/

class Solution {
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
