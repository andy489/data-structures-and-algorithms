// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

// Solution: Recursive Divide and Conquer (mid = left-mid) — O(n) time, O(log n) space
class Solution {
    private int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return build(0, nums.length - 1);
    }

    private TreeNode build(int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(lo, mid - 1);
        root.right = build(mid + 1, hi);
        return root;
    }
}

// Solution 2: Iterative (explicit stack with bounds and side) — O(n) time, O(n) space
class Solution2 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // Each entry: {parent, lo, hi, side} where side 0 = left, 1 = right
        Deque<int[]> stack = new ArrayDeque<>();
        Deque<TreeNode> parents = new ArrayDeque<>();
        stack.push(new int[]{0, mid - 1, 0});
        parents.push(root);
        stack.push(new int[]{mid + 1, nums.length - 1, 1});
        parents.push(root);
        while (!stack.isEmpty()) {
            int[] bounds = stack.pop();
            TreeNode parent = parents.pop();
            int lo = bounds[0], hi = bounds[1], side = bounds[2];
            if (lo > hi) continue;
            int m = (lo + hi) / 2;
            TreeNode node = new TreeNode(nums[m]);
            if (side == 0) parent.left = node;
            else parent.right = node;
            stack.push(new int[]{lo, m - 1, 0});
            parents.push(node);
            stack.push(new int[]{m + 1, hi, 1});
            parents.push(node);
        }
        return root;
    }
}
