// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

// Solution: DFS with Min/Max — O(n) time, O(h) space
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode node, int minVal, int maxVal) {
        if (node == null) {
            return maxVal - minVal;
        }
        minVal = Math.min(minVal, node.val);
        maxVal = Math.max(maxVal, node.val);
        return Math.max(dfs(node.left, minVal, maxVal), dfs(node.right, minVal, maxVal));
    }
}
