// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

// Solution: Recursive DFS + HashMap — O(n) time, O(n) space
class Solution {
    private int[] postorder;
    private Map<Integer, Integer> inorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return build(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode build(int inL, int inR, int postL, int postR) {
        if (inL > inR) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postR]);
        int mid = inorderIndex.get(postorder[postR]);
        int leftSize = mid - inL;
        root.left = build(inL, mid - 1, postL, postL + leftSize - 1);
        root.right = build(mid + 1, inR, postL + leftSize, postR - 1);
        return root;
    }
}

// Solution 2: Iterative Stack — O(n) time, O(n) space
class Solution2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int inorderIdx = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            TreeNode node = new TreeNode(postorder[i]);
            if (stack.peek().val != inorder[inorderIdx]) {
                stack.peek().right = node;
            } else {
                TreeNode parent = null;
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIdx]) {
                    parent = stack.pop();
                    inorderIdx--;
                }
                parent.left = node;
            }
            stack.push(node);
        }
        return root;
    }
}
