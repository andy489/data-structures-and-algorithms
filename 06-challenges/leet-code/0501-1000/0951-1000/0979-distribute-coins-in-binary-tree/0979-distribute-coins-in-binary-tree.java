// https://leetcode.com/problems/distribute-coins-in-binary-tree/

// Solution: DFS Post-order — O(n) time, O(h) space
class Solution {
    private int moves = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode node) {
        if (node == null) { return 0; }
        int left = dfs(node.left);
        int right = dfs(node.right);
        moves += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }
}
