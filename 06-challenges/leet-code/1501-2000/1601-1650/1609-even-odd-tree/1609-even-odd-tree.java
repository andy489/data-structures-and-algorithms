// https://leetcode.com/problems/even-odd-tree/

// Solution: BFS Level-Order Traversal — O(n) time, O(n) space
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean evenLevel = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int prev = evenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int val = node.val;
                if (evenLevel && (val % 2 == 0 || val <= prev)) {
                    return false;
                }
                if (!evenLevel && (val % 2 != 0 || val >= prev)) {
                    return false;
                }
                prev = val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            evenLevel = !evenLevel;
        }
        return true;
    }
}
