// https://leetcode.com/problems/validate-binary-search-tree/

// Solution: Bounded Recursion — O(n) time, O(h) space
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}

// Solution 2: Iterative In-order Traversal — O(n) time, O(h) space
class Solution2 {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        long prev = Long.MIN_VALUE;
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (curr.val <= prev) return false;
            prev = curr.val;
            curr = curr.right;
        }
        return true;
    }
}
