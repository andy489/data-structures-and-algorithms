// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

// Solution: BFS with ArrayDeque (addFirst, no reverse) — O(n) time, O(n) space
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> result = new ArrayDeque<>();
        if (root == null) {
            return new ArrayList<>(result);
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.addFirst(level);
        }
        return new ArrayList<>(result);
    }
}

// Solution 2: DFS (recursive, track depth) — O(n) time, O(n) space
class Solution2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        Collections.reverse(result);
        return result;
    }

    private void dfs(TreeNode node, int depth, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (result.size() == depth) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(node.val);
        dfs(node.left, depth + 1, result);
        dfs(node.right, depth + 1, result);
    }
}
