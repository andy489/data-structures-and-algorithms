// https://leetcode.com/problems/rotate-array/

// Triple reverse — O(n) time, O(1) space
var rotate = function(nums, k) {
    const n = nums.length;
    k %= n;
    const rev = (lo, hi) => { while (lo < hi) { [nums[lo], nums[hi]] = [nums[hi], nums[lo]]; lo++; hi--; } };
    rev(0, n - 1);
    rev(0, k - 1);
    rev(k, n - 1);
};
