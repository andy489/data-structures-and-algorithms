// https://leetcode.com/problems/balanced-binary-tree/

// Solution: DFS with Early Termination (Bottom-Up Height Check) — O(n) time, O(h) space
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left);
        if (lh == -1) {
            return -1;
        }
        int rh = height(node.right);
        if (rh == -1) {
            return -1;
        }
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }
        return Math.max(lh, rh) + 1;
    }
}

// Solution 2: Top-Down DFS (Naive) — O(n^2) time, O(h) space
class Solution2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.abs(lh - rh) <= 1
            && isBalanced(root.left)
            && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}

// Solution 3: Iterative Post-Order with Height Map — O(n) time, O(n) space
class Solution3 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Map<TreeNode, Integer> heights = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == prev) {
                stack.pop();
                int lh = heights.getOrDefault(cur.left, 0);
                int rh = heights.getOrDefault(cur.right, 0);
                if (Math.abs(lh - rh) > 1) {
                    return false;
                }
                heights.put(cur, Math.max(lh, rh) + 1);
                prev = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
        return true;
    }
}
