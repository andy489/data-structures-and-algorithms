// https://leetcode.com/problems/maximum-binary-tree-ii/

// Solution: Right Spine Traversal — O(h) time, O(1) space
class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null || root.val < val) {
            newNode.left = root;
            return newNode;
        }
        TreeNode cur = root;
        while (cur.right != null && cur.right.val > val) {
            cur = cur.right;
        }
        newNode.left = cur.right;
        cur.right = newNode;
        return root;
    }
}
