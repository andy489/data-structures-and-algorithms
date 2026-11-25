// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

// Solution: Recursive — O(n^2) time, O(n) space
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] pre, int pl, int pr, int[] post, int ql, int qr) {
        if (pl > pr) {
            return null;
        }
        TreeNode root = new TreeNode(pre[pl]);
        if (pl == pr) {
            return root;
        }
        int leftRoot = pre[pl + 1];
        int L = ql;
        while (post[L] != leftRoot) {
            L++;
        }
        int leftSize = L - ql + 1;
        root.left = build(pre, pl + 1, pl + leftSize, post, ql, L);
        root.right = build(pre, pl + leftSize + 1, pr, post, L + 1, qr - 1);
        return root;
    }
}
