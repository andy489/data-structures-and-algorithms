// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

// Solution: DFS + Sort — O(n log n) time, O(n) space
class Solution {
    private List<int[]> nodes = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        nodes.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
        List<List<Integer>> res = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        for (int[] node : nodes) {
            if (node[0] != prevCol) { res.add(new ArrayList<>()); prevCol = node[0]; }
            res.get(res.size() - 1).add(node[2]);
        }
        return res;
    }

    private void dfs(TreeNode node, int col, int row) {
        if (node == null) { return; }
        nodes.add(new int[]{col, row, node.val});
        dfs(node.left, col - 1, row + 1);
        dfs(node.right, col + 1, row + 1);
    }
}
