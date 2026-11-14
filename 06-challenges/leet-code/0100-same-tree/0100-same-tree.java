// https://leetcode.com/problems/same-tree/

// Solution: Recursion — O(n) time, O(h) space
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// Solution 2: Iterative BFS — O(n) time, O(n) space
class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode a = queue.poll();
            TreeNode b = queue.poll();
            if (a == null && b == null) continue;
            if (a == null || b == null) return false;
            if (a.val != b.val) return false;
            queue.offer(a.left);
            queue.offer(b.left);
            queue.offer(a.right);
            queue.offer(b.right);
        }
        return true;
    }
}

// Solution 3: Iterative DFS — O(n) time, O(h) space
class Solution3 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(p);
        stack.push(q);
        while (!stack.isEmpty()) {
            TreeNode a = stack.pop();
            TreeNode b = stack.pop();
            if (a == null && b == null) continue;
            if (a == null || b == null) return false;
            if (a.val != b.val) return false;
            stack.push(a.left);
            stack.push(b.left);
            stack.push(a.right);
            stack.push(b.right);
        }
        return true;
    }
}
