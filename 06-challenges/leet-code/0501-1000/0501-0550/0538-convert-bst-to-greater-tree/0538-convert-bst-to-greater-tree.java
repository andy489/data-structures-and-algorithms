// https://leetcode.com/problems/convert-bst-to-greater-tree/

// Solution: Reverse Inorder Traversal — O(n) time, O(h) space
class Solution {
    private int runningSum = 0;

    public TreeNode convertBST(TreeNode root) {
        reverseInorder(root);
        return root;
    }

    private void reverseInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        reverseInorder(node.right);
        runningSum += node.val;
        node.val = runningSum;
        reverseInorder(node.left);
    }
}
