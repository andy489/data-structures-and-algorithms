// https://leetcode.com/problems/k-th-largest-perfect-subtree-size-in-binary-tree/

class Solution {
    private List<Integer> sizes = new ArrayList<>();

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        if (left == -1 || right == -1 || left != right) {
            return -1;
        }
        int size = left + right + 1;
        sizes.add(size);
        return size;
    }

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        dfs(root);
        sizes.sort(Collections.reverseOrder());
        return sizes.size() >= k ? sizes.get(k - 1) : -1;
    }
}
