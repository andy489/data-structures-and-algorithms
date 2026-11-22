// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

// Solution: Iterative Inorder — O(H+k) time, O(H) space
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (--k == 0) {
                return curr.val;
            }
            curr = curr.right;
        }
        return -1;
    }
}

// Solution 2: Recursive Inorder — O(n) time, O(H) space
class Solution2 {
    private int count;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode node) {
        if (node == null || count <= 0) {
            return;
        }
        inorder(node.left);
        if (--count == 0) {
            result = node.val;
        }
        inorder(node.right);
    }
}
