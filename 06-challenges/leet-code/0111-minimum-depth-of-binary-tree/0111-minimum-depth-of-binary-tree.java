// https://leetcode.com/problems/minimum-depth-of-binary-tree/

// Solution: BFS Level-Order — O(n) time, O(w) space
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left  != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return depth;
    }
}

// Solution 2: DFS Recursive — O(n) time, O(h) space
class Solution2 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}

// Solution 3: Iterative DFS with (node, depth) stack — O(n) time, O(h) space
class Solution3 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        Deque<Object[]> stack = new ArrayDeque<>();
        stack.push(new Object[]{root, 1});
        while (!stack.isEmpty()) {
            Object[] entry = stack.pop();
            TreeNode node = (TreeNode) entry[0];
            int depth = (int) entry[1];
            if (node.left == null && node.right == null) {
                min = Math.min(min, depth);
            }
            if (node.right != null) stack.push(new Object[]{node.right, depth + 1});
            if (node.left  != null) stack.push(new Object[]{node.left,  depth + 1});
        }
        return min;
    }
}

// Solution 4: Recursive DFS with depth parameter and shared min — O(n) time, O(h) space
class Solution4 {
    private int min;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        min = Integer.MAX_VALUE;
        dfs(root, 1);
        return min;
    }

    private void dfs(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            min = Math.min(min, depth);
            return;
        }
        if (node.left  != null) dfs(node.left,  depth + 1);
        if (node.right != null) dfs(node.right, depth + 1);
    }
}
