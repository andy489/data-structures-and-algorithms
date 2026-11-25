// https://leetcode.com/problems/univalued-binary-tree/

// Solution: DFS — O(n) time, O(h) space
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return check(root, root.val);
    }

    private boolean check(TreeNode node, int val) {
        if (node == null) { return true; }
        if (node.val != val) { return false; }
        return check(node.left, val) && check(node.right, val);
    }
}
