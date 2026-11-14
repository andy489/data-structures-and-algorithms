// https://leetcode.com/problems/recover-binary-search-tree/

// Solution: In-order Traversal (Iterative) — O(n) time, O(h) space
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null, prev = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev != null && prev.val > curr.val) {
                if (first == null) first = prev;
                second = curr;
            }
            prev = curr;
            curr = curr.right;
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}

// Solution 2: Morris In-order Traversal — O(n) time, O(1) space
class Solution2 {
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null, prev = null;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                if (prev != null && prev.val > curr.val) {
                    if (first == null) first = prev;
                    second = curr;
                }
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    if (prev != null && prev.val > curr.val) {
                        if (first == null) first = prev;
                        second = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
