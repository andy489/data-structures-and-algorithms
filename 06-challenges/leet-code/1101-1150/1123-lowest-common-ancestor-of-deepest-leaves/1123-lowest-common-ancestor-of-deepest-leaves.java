// https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/

// Solution: DFS — O(n) time, O(h) space
class Solution {
    private TreeNode lca;
    private int maxDepth;

    private int dfs(TreeNode node, int depth) {
        if (node == null) {
            return depth - 1;
        }
        int left = dfs(node.left, depth + 1);
        int right = dfs(node.right, depth + 1);
        int deepest = Math.max(left, right);
        if (left == deepest && right == deepest && deepest >= maxDepth) {
            maxDepth = deepest;
            lca = node;
        }
        return deepest;
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        lca = root;
        maxDepth = 0;
        dfs(root, 0);
        return lca;
    }
}
