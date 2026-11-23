class Solution {
    private int totalTilt = 0;

    public int findTilt(TreeNode root) {
        subtreeSum(root);
        return totalTilt;
    }

    private int subtreeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = subtreeSum(node.left);
        int right = subtreeSum(node.right);
        totalTilt += Math.abs(left - right);
        return node.val + left + right;
    }
}
