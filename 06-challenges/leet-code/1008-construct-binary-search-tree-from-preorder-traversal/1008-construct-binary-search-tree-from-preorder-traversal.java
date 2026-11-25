// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

// Solution: Recursive with Bound — O(n) time, O(n) space
class Solution {
    private int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] pre, int bound) {
        if (idx == pre.length || pre[idx] > bound) {
            return null;
        }
        TreeNode node = new TreeNode(pre[idx++]);
        node.left = build(pre, node.val);
        node.right = build(pre, bound);
        return node;
    }
}
