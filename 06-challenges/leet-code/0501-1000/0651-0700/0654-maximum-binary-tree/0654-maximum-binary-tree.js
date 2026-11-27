// https://leetcode.com/problems/maximum-binary-tree/

var constructMaximumBinaryTree = function(nums) {
    function build(lo, hi) {
        if (lo > hi) return null;
        let maxIdx = lo;
        for (let i = lo + 1; i <= hi; i++) {
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }
        const node = new TreeNode(nums[maxIdx]);
        node.left = build(lo, maxIdx - 1);
        node.right = build(maxIdx + 1, hi);
        return node;
    }
    return build(0, nums.length - 1);
};
