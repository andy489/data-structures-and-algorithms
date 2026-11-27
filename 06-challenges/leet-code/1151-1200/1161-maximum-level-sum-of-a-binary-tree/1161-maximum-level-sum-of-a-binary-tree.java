// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

// Solution: BFS Level-Order Traversal — O(n) time, O(w) space
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int bestLevel = 1, level = 0;
        long bestSum = Long.MIN_VALUE;
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            if (sum > bestSum) {
                bestSum = sum;
                bestLevel = level;
            }
        }
        return bestLevel;
    }
}
