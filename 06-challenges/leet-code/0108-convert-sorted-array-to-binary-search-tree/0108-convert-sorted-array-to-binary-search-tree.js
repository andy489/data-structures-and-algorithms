// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

var sortedArrayToBST = function(nums) {
    function build(lo, hi) {
        if (lo > hi) return null;
        const mid = (lo + hi) >> 1;
        const root = new TreeNode(nums[mid]);
        root.left = build(lo, mid - 1);
        root.right = build(mid + 1, hi);
        return root;
    }
    return build(0, nums.length - 1);
};

var sortedArrayToBST2 = function(nums) {
    const mid = nums.length >> 1;
    const root = new TreeNode(nums[mid]);
    // stack entries: [parent, lo, hi, side]  side: 0=left, 1=right
    const stack = [
        [root, 0, mid - 1, 0],
        [root, mid + 1, nums.length - 1, 1]
    ];
    while (stack.length) {
        const [parent, lo, hi, side] = stack.pop();
        if (lo > hi) continue;
        const m = (lo + hi) >> 1;
        const node = new TreeNode(nums[m]);
        if (side === 0) parent.left = node;
        else parent.right = node;
        stack.push([node, lo, m - 1, 0]);
        stack.push([node, m + 1, hi, 1]);
    }
    return root;
};
