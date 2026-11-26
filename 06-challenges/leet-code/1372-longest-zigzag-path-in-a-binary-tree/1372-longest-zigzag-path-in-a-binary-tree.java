// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/

// Solution: DFS — O(n) time, O(h) space
class Solution {
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        dfs(root, false, 0);
        return ans;
    }
    private void dfs(TreeNode node, boolean goLeft, int length) {
        if (node == null) return;
        ans = Math.max(ans, length);
        if (goLeft) {
            dfs(node.left, false, length+1);
            dfs(node.right, true, 1);
        } else {
            dfs(node.right, true, length+1);
            dfs(node.left, false, 1);
        }
    }
}
