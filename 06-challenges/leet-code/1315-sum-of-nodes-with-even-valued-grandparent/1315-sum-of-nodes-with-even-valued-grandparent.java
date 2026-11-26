// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/

// Solution: DFS — O(n) time, O(h) space
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, 1, 1);
    }
    private int dfs(TreeNode node, int parent, int grandparent) {
        if (node == null) return 0;
        int sum = (grandparent % 2 == 0) ? node.val : 0;
        return sum + dfs(node.left, node.val, parent) + dfs(node.right, node.val, parent);
    }
}
