// https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/

// Solution: DFS returning (depth, LCA) — O(n) time, O(n) space
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root)[0];
    }

    private TreeNode[] dfs(TreeNode node) {
        if (node == null) {
            return new TreeNode[]{null, new TreeNode(0)};
        }
        TreeNode[] left = dfs(node.left);
        TreeNode[] right = dfs(node.right);
        int ld = left[1].val, rd = right[1].val;
        if (ld == rd) {
            return new TreeNode[]{node, new TreeNode(ld + 1)};
        } else if (ld > rd) {
            return new TreeNode[]{left[0], new TreeNode(ld + 1)};
        } else {
            return new TreeNode[]{right[0], new TreeNode(rd + 1)};
        }
    }
}
