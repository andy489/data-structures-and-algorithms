// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/

// Solution: Two-pass DFS — O(n) time, O(h) space
class Solution {
    long total = 0, best = 0;
    public int maxProduct(TreeNode root) {
        total = subtreeSum(root);
        subtreeSum2(root);
        return (int)(best % 1_000_000_007L);
    }
    private long subtreeSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + subtreeSum(node.left) + subtreeSum(node.right);
    }
    private long subtreeSum2(TreeNode node) {
        if (node == null) return 0;
        long s = node.val + subtreeSum2(node.left) + subtreeSum2(node.right);
        best = Math.max(best, s * (total - s));
        return s;
    }
}
