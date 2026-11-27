// https://leetcode.com/problems/linked-list-in-binary-tree/

// Solution: DFS — O(n*m) time, O(h) space
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return match(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    private boolean match(ListNode node, TreeNode tNode) {
        if (node == null) return true;
        if (tNode == null || tNode.val != node.val) return false;
        return match(node.next, tNode.left) || match(node.next, tNode.right);
    }
}
