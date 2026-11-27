// https://leetcode.com/problems/delete-nodes-and-return-forest/

// Solution: Post-order DFS — O(n) time, O(n + d) space
class Solution {
    private Set<Integer> deleteSet;
    private List<TreeNode> result;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        deleteSet = new HashSet<>();
        result = new ArrayList<>();
        for (int val : to_delete) {
            deleteSet.add(val);
        }
        dfs(root, true);
        return result;
    }

    private TreeNode dfs(TreeNode node, boolean isRoot) {
        if (node == null) {
            return null;
        }
        boolean deleted = deleteSet.contains(node.val);
        if (!deleted && isRoot) {
            result.add(node);
        }
        node.left = dfs(node.left, deleted);
        node.right = dfs(node.right, deleted);
        return deleted ? null : node;
    }
}
