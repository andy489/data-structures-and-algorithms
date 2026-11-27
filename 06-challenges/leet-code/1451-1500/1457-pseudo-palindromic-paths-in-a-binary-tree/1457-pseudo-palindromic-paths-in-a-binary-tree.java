// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/

// Solution: DFS with Bitmask — O(n) time, O(n) space
class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, 0);
    }
    private int dfs(TreeNode node, int mask) {
        if (node == null) return 0;
        mask ^= (1 << node.val);
        if (node.left == null && node.right == null)
            return (mask & (mask-1)) == 0 ? 1 : 0;
        return dfs(node.left, mask) + dfs(node.right, mask);
    }
}
