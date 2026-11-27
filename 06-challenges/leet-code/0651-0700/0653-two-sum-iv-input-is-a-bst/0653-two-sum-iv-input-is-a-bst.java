// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

// Solution: DFS + HashSet — O(n) time, O(n) space
class Solution {
    private Set<Integer> seen = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (seen.contains(k - root.val)) {
            return true;
        }
        seen.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}

// Solution 2: BFS + HashSet — O(n) time, O(n) space
class Solution2 {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> seen = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (seen.contains(k - node.val)) {
                return true;
            }
            seen.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }
}
