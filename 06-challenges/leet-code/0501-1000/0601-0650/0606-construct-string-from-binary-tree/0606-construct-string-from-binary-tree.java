// https://leetcode.com/problems/construct-string-from-binary-tree/

// Solution: DFS Recursion — O(n) time, O(n) space
class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (root.left != null || root.right != null) {
            sb.append('(').append(tree2str(root.left)).append(')');
        }
        if (root.right != null) {
            sb.append('(').append(tree2str(root.right)).append(')');
        }
        return sb.toString();
    }
}
