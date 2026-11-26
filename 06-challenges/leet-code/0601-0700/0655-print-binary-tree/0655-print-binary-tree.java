// https://leetcode.com/problems/print-binary-tree/

// Solution: DFS Fill — O(n) time, O(n) space
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int cols = (1 << (height + 1)) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i <= height; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add("");
            }
            res.add(row);
        }
        fill(res, root, 0, (cols - 1) / 2, height);
        return res;
    }

    private void fill(List<List<String>> res, TreeNode node, int row, int col, int height) {
        if (node == null) {
            return;
        }
        res.get(row).set(col, String.valueOf(node.val));
        int offset = 1 << (height - row - 1);
        fill(res, node.left, row + 1, col - offset, height);
        fill(res, node.right, row + 1, col + offset, height);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
