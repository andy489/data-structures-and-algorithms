// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

// Solution 1: BFS with Direction Flag — O(n) time, O(n) space
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
            leftToRight = !leftToRight;
        }
        return result;
    }
}

// Solution 2: DFS with Depth — O(n) time, O(n) space
class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int depth, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(new LinkedList<>());
        }
        LinkedList<Integer> level = (LinkedList<Integer>) result.get(depth);
        if (depth % 2 == 0) {
            level.addLast(node.val);
        } else {
            level.addFirst(node.val);
        }
        dfs(node.left, depth + 1, result);
        dfs(node.right, depth + 1, result);
    }
}
