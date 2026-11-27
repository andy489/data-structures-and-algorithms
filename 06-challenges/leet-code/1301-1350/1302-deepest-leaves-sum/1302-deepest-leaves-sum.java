// https://leetcode.com/problems/deepest-leaves-sum/

// Solution: BFS — O(n) time, O(n) space
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        while (!q.isEmpty()) {
            sum = 0;
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return sum;
    }
}
