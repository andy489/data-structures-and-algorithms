// https://leetcode.com/problems/maximum-width-of-binary-tree/

// Solution: BFS with Index — O(n) time, O(n) space
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Long> idxQ = new LinkedList<>();
        nodeQ.offer(root);
        idxQ.offer(0L);
        while (!nodeQ.isEmpty()) {
            int size = nodeQ.size();
            long first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQ.poll();
                long idx = idxQ.poll();
                if (i == 0) {
                    first = idx;
                }
                last = idx;
                long norm = idx - first;
                if (node.left != null) {
                    nodeQ.offer(node.left);
                    idxQ.offer(2 * norm);
                }
                if (node.right != null) {
                    nodeQ.offer(node.right);
                    idxQ.offer(2 * norm + 1);
                }
            }
            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }
        return maxWidth;
    }
}
