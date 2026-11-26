// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

// Solution: Postorder DFS — O(n) time, O(h) space
class Solution {
    int ans = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }
    // returns [isBST(1/0), min, max, sum]
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] L = dfs(node.left), R = dfs(node.right);
        if (L[0]==1 && R[0]==1 && node.val > L[2] && node.val < R[1]) {
            int sum = node.val + L[3] + R[3];
            ans = Math.max(ans, sum);
            return new int[]{1, Math.min(L[1], node.val), Math.max(R[2], node.val), sum};
        }
        return new int[]{0, 0, 0, 0};
    }
}
