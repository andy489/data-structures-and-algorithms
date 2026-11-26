// https://leetcode.com/problems/balance-a-binary-search-tree/

// Solution: Inorder + Build — O(n) time, O(n) space
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);
        return build(nodes, 0, nodes.size()-1);
    }
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
    private TreeNode build(List<Integer> nodes, int lo, int hi) {
        if (lo > hi) return null;
        int mid = (lo + hi) / 2;
        TreeNode node = new TreeNode(nodes.get(mid));
        node.left = build(nodes, lo, mid-1);
        node.right = build(nodes, mid+1, hi);
        return node;
    }
}
