// https://leetcode.com/problems/binary-tree-level-order-traversal/

// Solution 1: BFS with Level Snapshot — O(n) time, O(n) space
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}

// Solution 2: DFS with Depth — O(n) time, O(n) space
class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int depth, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(node.val);
        dfs(node.left, depth + 1, result);
        dfs(node.right, depth + 1, result);
    }
}
