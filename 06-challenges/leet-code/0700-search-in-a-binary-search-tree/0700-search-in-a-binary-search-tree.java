// https://leetcode.com/problems/search-in-a-binary-search-tree/

// Solution: Iterative BST Search — O(h) time, O(1) space
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}

// Solution 2: Recursive — O(h) time, O(h) space
class Solution2 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
