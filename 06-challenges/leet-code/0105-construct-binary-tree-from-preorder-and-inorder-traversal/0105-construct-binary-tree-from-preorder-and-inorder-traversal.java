// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// Solution: Recursive DFS with HashMap — O(n) time, O(n) space
class Solution {
    private int[] preorder;
    private Map<Integer, Integer> inorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return build(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int preL, int preR, int inL, int inR) {
        if (preL > preR) {
            return null;
        }
        int rootVal = preorder[preL];
        int mid = inorderIndex.get(rootVal);
        int leftSize = mid - inL;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preL + 1, preL + leftSize, inL, mid - 1);
        root.right = build(preL + leftSize + 1, preR, mid + 1, inR);
        return root;
    }
}
