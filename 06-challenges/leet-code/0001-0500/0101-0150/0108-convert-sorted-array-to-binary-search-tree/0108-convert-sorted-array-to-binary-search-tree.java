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
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(lo, mid - 1);
        root.right = build(mid + 1, hi);
        return root;
    }
}

// Solution 2: Iterative (explicit stack with bounds and side) — O(n) time, O(n) space
class Solution2 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = (nums.length - 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // Two parallel stacks: bounds holds {lo, hi, side}; parents holds the parent node.
        // side 0 = attach as left child, side 1 = attach as right child.
        Deque<int[]> stack = new ArrayDeque<>();
        Deque<TreeNode> parents = new ArrayDeque<>();
        stack.push(new int[]{0, mid - 1, 0});         // left subtree of root
        parents.push(root);
        stack.push(new int[]{mid + 1, nums.length - 1, 1}); // right subtree of root
        parents.push(root);
        while (!stack.isEmpty()) {
            int[] bounds = stack.pop();
            TreeNode parent = parents.pop();
            int lo = bounds[0], hi = bounds[1], side = bounds[2];
            if (lo > hi) continue;                    // empty range — nothing to build
            int m = lo + (hi - lo) / 2;
            TreeNode node = new TreeNode(nums[m]);
            if (side == 0) parent.left = node;        // attach to left
            else           parent.right = node;       // attach to right
            stack.push(new int[]{lo, m - 1, 0});      // node's left subtree
            parents.push(node);
            stack.push(new int[]{m + 1, hi, 1});      // node's right subtree
            parents.push(node);
        }
        return root;
    }
}
