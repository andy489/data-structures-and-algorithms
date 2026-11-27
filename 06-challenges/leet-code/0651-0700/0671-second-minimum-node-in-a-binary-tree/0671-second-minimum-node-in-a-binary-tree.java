// https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/

// Solution: DFS — O(n) time, O(n) space
class Solution {
    private long result = Long.MAX_VALUE;
    private long min;

    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        dfs(root);
        return result == Long.MAX_VALUE ? -1 : (int) result;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val > min && node.val < result) {
            result = node.val;
            return;
        }
        dfs(node.left);
        dfs(node.right);
    }
}
