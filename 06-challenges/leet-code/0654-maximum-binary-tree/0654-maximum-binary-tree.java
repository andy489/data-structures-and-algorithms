// https://leetcode.com/problems/maximum-binary-tree/

// Solution: Recursive Divide and Conquer — O(n²) time, O(n) space
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int maxIdx = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = build(nums, lo, maxIdx - 1);
        root.right = build(nums, maxIdx + 1, hi);
        return root;
    }
}
