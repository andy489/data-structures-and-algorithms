// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/

// Solution: DFS + HashSet — O(n) init, O(1) find time, O(n) space
// Solution: DFS + HashSet — O(n) init, O(1) find time, O(n) space
class FindElements {
    private Set<Integer> vals = new HashSet<>();
    public FindElements(TreeNode root) { dfs(root, 0); }
    private void dfs(TreeNode node, int val) {
        if (node == null) return;
        vals.add(val);
        dfs(node.left, 2 * val + 1);
        dfs(node.right, 2 * val + 2);
    }
    public boolean find(int target) { return vals.contains(target); }
}
