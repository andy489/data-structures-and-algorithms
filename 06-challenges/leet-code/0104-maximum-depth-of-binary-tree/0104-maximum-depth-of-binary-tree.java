// https://leetcode.com/problems/maximum-depth-of-binary-tree/

// Solution 1: DFS Recursive — O(n) time, O(h) space
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

// Solution 2: BFS Iterative — O(n) time, O(n) space
class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }
}

// Solution 3: DFS Iterative (Explicit Stack) — O(n) time, O(h) space
class Solution3 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Integer> depths = new ArrayDeque<>();
        nodes.push(root);
        depths.push(1);
        int max = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int d = depths.pop();
            max = Math.max(max, d);
            if (node.right != null) {
                nodes.push(node.right);
                depths.push(d + 1);
            }
            if (node.left != null) {
                nodes.push(node.left);
                depths.push(d + 1);
            }
        }
        return max;
    }
}
