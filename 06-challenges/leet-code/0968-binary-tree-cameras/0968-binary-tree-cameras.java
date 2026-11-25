// https://leetcode.com/problems/binary-tree-cameras/

// Solution: Greedy DFS — O(n) time, O(h) space
class Solution {
    private int cameras = 0;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) { cameras++; }
        return cameras;
    }

    // 0: not covered, 1: covered (no camera), 2: has camera
    private int dfs(TreeNode node) {
        if (node == null) { return 1; }
        int left = dfs(node.left);
        int right = dfs(node.right);
        if (left == 0 || right == 0) {
            cameras++;
            return 2;
        }
        if (left == 2 || right == 2) { return 1; }
        return 0;
    }
}
