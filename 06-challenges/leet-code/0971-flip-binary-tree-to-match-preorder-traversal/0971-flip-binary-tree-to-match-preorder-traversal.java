// https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/

// Solution: DFS Preorder — O(n) time, O(n) space
class Solution {
    private int idx = 0;
    private List<Integer> res = new ArrayList<>();
    private boolean failed = false;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        dfs(root, voyage);
        if (failed) { return List.of(-1); }
        return res;
    }

    private void dfs(TreeNode node, int[] voyage) {
        if (node == null || failed) { return; }
        if (node.val != voyage[idx++]) {
            failed = true;
            return;
        }
        if (node.left != null && node.left.val != voyage[idx]) {
            res.add(node.val);
            dfs(node.right, voyage);
            dfs(node.left, voyage);
        } else {
            dfs(node.left, voyage);
            dfs(node.right, voyage);
        }
    }
}
