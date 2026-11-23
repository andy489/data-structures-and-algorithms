// https://leetcode.com/problems/rotate-function/

// Solution: Math / Incremental Update — O(n) time, O(1) space
var maxRotateFunction = function(nums) {
    const n = nums.length;
    let total = 0, f = 0;
    for (let i = 0; i < n; i++) {
        total += nums[i];
        f += i * nums[i];
    }
    let max = f;
    for (let k = 1; k < n; k++) {
        f = f + total - n * nums[n - k];
        if (f > max) max = f;
    }
    return max;
};
