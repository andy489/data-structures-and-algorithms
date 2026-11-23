// https://leetcode.com/problems/n-ary-tree-level-order-traversal/

// Solution: BFS — O(n) time, O(n) space
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelValues = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                levelValues.add(node.val);
                for (Node child : node.children) {
                    queue.offer(child);
                }
            }
            levels.add(levelValues);
        }
        return levels;
    }
}
