// https://leetcode.com/problems/maximize-the-topmost-element-after-k-moves/
var maximumTop = function(nums, k) {
    const n = nums.length;
    if (n === 1) {
        return k % 2 === 0 ? nums[0] : -1;
    }
    if (k === 0) {
        return nums[0];
    }
    let best = -1;
    const limit = Math.min(k - 1, n);
    for (let i = 0; i < limit; i++) {
        best = Math.max(best, nums[i]);
    }
    if (k < n) {
        best = Math.max(best, nums[k]);
    }
    return best;
};
