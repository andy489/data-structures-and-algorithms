// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
var findUnsortedSubarray = function(nums) {
    const n = nums.length;
    let left = -1, right = -1;
    let runMax = -Infinity, runMin = Infinity;
    for (let i = 0; i < n; i++) {
        if (nums[i] < runMax) {
            right = i;
        }
        runMax = Math.max(runMax, nums[i]);
    }
    if (right === -1) {
        return 0;
    }
    for (let i = n - 1; i >= 0; i--) {
        if (nums[i] > runMin) {
            left = i;
        }
        runMin = Math.min(runMin, nums[i]);
    }
    return right - left + 1;
};
