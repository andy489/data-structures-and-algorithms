// https://leetcode.com/problems/delete-node-in-a-bst/

// Solution: Recursive BST Deletion — O(h) time, O(h) space
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }
}
