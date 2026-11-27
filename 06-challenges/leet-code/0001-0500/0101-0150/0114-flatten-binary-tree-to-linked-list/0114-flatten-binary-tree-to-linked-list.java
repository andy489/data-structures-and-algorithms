// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

// Solution 1: Post-order Recursion — O(n) time, O(h) space
class Solution {
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode tail = root;
        while (tail.right != null) {
            tail = tail.right;
        }
        tail.right = right;
    }
}

// Solution 2: Morris-like In-place — O(n) time, O(1) space
class Solution2 {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode pred = curr.left;
                while (pred.right != null) {
                    pred = pred.right;
                }
                pred.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}

// Solution 3: Explicit Stack (Iterative Pre-order) — O(n) time, O(h) space
class Solution3 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null) {
                prev.right = curr;
                prev.left = null;
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
            prev = curr;
        }
        prev.left = null;
    }
}
