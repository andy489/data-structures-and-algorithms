// https://leetcode.com/problems/delete-leaves-with-a-given-value/

// Solution: Postorder DFS — O(n) time, O(h) space
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        return (root.left == null && root.right == null && root.val == target) ? null : root;
    }
}
