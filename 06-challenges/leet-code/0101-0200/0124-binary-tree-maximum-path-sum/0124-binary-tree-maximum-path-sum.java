// https://leetcode.com/problems/binary-tree-maximum-path-sum/

// Solution: Post-order DFS — O(n) time, O(h) space
class Solution {
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftGain = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));
        ans = Math.max(ans, node.val + leftGain + rightGain);
        return node.val + Math.max(leftGain, rightGain);
    }
}
