// https://leetcode.com/problems/check-completeness-of-a-binary-tree/

// Solution: BFS Level Order — O(n) time, O(n) space
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean seenNull = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                seenNull = true;
            } else {
                if (seenNull) { return false; }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }
}
