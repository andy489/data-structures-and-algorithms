// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

// Solution: Parallel DFS — O(n) time, O(h) space
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;
        if (original == target) return cloned;
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        return left != null ? left : getTargetCopy(original.right, cloned.right, target);
    }
}
