// https://leetcode.com/problems/longest-univalue-path/

// Solution: DFS Post-order — O(n) time, O(n) space
class Solution {
    private int maxPath = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxPath;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftArm = dfs(node.left);
        int rightArm = dfs(node.right);
        int left = (node.left != null && node.left.val == node.val) ? leftArm + 1 : 0;
        int right = (node.right != null && node.right.val == node.val) ? rightArm + 1 : 0;
        maxPath = Math.max(maxPath, left + right);
        return Math.max(left, right);
    }
}
