// https://leetcode.com/problems/smallest-string-starting-from-leaf/

// Solution: DFS + String Building — O(n²) time, O(n) space
class Solution {
    private String ans = null;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    private void dfs(TreeNode node, StringBuilder path) {
        if (node == null) { return; }
        path.append((char)('a' + node.val));
        if (node.left == null && node.right == null) {
            String s = path.reverse().toString();
            path.reverse();
            if (ans == null || s.compareTo(ans) < 0) { ans = s; }
        } else {
            dfs(node.left, path);
            dfs(node.right, path);
        }
        path.deleteCharAt(path.length() - 1);
    }
}
