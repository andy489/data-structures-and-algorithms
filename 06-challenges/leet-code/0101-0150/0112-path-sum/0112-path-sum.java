// https://leetcode.com/problems/path-sum/

// Solution: DFS Recursive — O(n) time, O(h) space
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}

// Solution 2: Iterative DFS with (node, remainingSum) Stack — O(n) time, O(h) space
class Solution2 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Deque<Object[]> stack = new ArrayDeque<>();
        stack.push(new Object[]{root, targetSum - root.val});
        while (!stack.isEmpty()) {
            Object[] entry = stack.pop();
            TreeNode node = (TreeNode) entry[0];
            int remaining = (int) entry[1];
            if (node.left == null && node.right == null && remaining == 0) {
                return true;
            }
            if (node.right != null) stack.push(new Object[]{node.right, remaining - node.right.val});
            if (node.left  != null) stack.push(new Object[]{node.left,  remaining - node.left.val});
        }
        return false;
    }
}

// Solution 3: BFS with (node, remainingSum) Queue — O(n) time, O(w) space
class Solution3 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Deque<Object[]> queue = new ArrayDeque<>();
        queue.offer(new Object[]{root, targetSum - root.val});
        while (!queue.isEmpty()) {
            Object[] entry = queue.poll();
            TreeNode node = (TreeNode) entry[0];
            int remaining = (int) entry[1];
            if (node.left == null && node.right == null && remaining == 0) {
                return true;
            }
            if (node.left  != null) queue.offer(new Object[]{node.left,  remaining - node.left.val});
            if (node.right != null) queue.offer(new Object[]{node.right, remaining - node.right.val});
        }
        return false;
    }
}
