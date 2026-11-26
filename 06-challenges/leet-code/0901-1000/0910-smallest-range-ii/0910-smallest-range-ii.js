// https://leetcode.com/problems/smallest-range-ii/

var smallestRangeII = function(nums, k) {
    nums.sort((a, b) => a - b);
    const n = nums.length;
    let result = nums[n-1] - nums[0];
    for (let i = 0; i < n - 1; i++) {
        const hi = Math.max(nums[i] + k, nums[n-1] - k);
        const lo = Math.min(nums[0] + k, nums[i+1] - k);
        result = Math.min(result, hi - lo);
    }
    return result;
};
