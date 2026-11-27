// https://leetcode.com/problems/binary-tree-coloring-game/

// Solution: Tree Partition Analysis — O(n) time, O(h) space
class Solution {
    private int left, right;

    private int count(TreeNode node, int x) {
        if (node == null) {
            return 0;
        }
        int l = count(node.left, x);
        int r = count(node.right, x);
        if (node.val == x) {
            left = l;
            right = r;
        }
        return l + r + 1;
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        count(root, x);
        int parent = n - left - right - 1;
        return Math.max(Math.max(left, right), parent) > n / 2;
    }
}
