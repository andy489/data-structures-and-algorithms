// https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/

var maxAbsoluteSum = function(nums) {
    let maxSum = 0, minSum = 0;
    let curMax = 0, curMin = 0;
    for (const n of nums) {
        curMax = Math.max(curMax + n, n);
        maxSum = Math.max(maxSum, curMax);
        curMin = Math.min(curMin + n, n);
        minSum = Math.min(minSum, curMin);
    }
    return Math.max(maxSum, -minSum);
};
