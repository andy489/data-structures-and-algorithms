// https://leetcode.com/problems/find-bottom-left-tree-value/

// Solution: BFS Right-to-Left — O(n) time, O(n) space
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode last = root;
        while (!queue.isEmpty()) {
            last = queue.poll();
            if (last.right != null) {
                queue.offer(last.right);
            }
            if (last.left != null) {
                queue.offer(last.left);
            }
        }
        return last.val;
    }
}

// Solution 2: DFS — O(n) time, O(h) space
class Solution2 {
    private int maxDepth = -1;
    private int result = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth > maxDepth) {
            maxDepth = depth;
            result = node.val;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
