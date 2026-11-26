// https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/

// Solution: Post-order DFS with Depth Arrays — O(n * distance) time, O(n * distance) space
class Solution {
    private int result = 0;
    private int maxDist;

    public int countPairs(TreeNode root, int distance) {
        this.maxDist = distance;
        dfs(root);
        return result;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[maxDist + 1];
        }
        if (node.left == null && node.right == null) {
            int[] depths = new int[maxDist + 1];
            depths[1] = 1;
            return depths;
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        for (int i = 1; i <= maxDist; i++) {
            for (int j = 1; j <= maxDist - i; j++) {
                result += left[i] * right[j];
            }
        }
        int[] merged = new int[maxDist + 1];
        for (int i = 1; i < maxDist; i++) {
            merged[i + 1] += left[i] + right[i];
        }
        return merged;
    }
}
