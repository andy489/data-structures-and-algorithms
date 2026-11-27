// https://leetcode.com/problems/range-sum-of-bst/

var rangeSumBST = function(root, low, high) {
    if (!root) return 0;
    let sum = (root.val >= low && root.val <= high) ? root.val : 0;
    if (root.val > low) sum += rangeSumBST(root.left, low, high);
    if (root.val < high) sum += rangeSumBST(root.right, low, high);
    return sum;
};
