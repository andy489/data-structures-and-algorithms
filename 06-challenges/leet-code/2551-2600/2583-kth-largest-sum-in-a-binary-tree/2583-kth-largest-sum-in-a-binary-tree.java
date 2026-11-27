// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> sums = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            sums.add(levelSum);
        }
        if (sums.size() < k) {
            return -1;
        }
        sums.sort(Collections.reverseOrder());
        return sums.get(k - 1);
    }
}
