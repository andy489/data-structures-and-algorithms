// https://leetcode.com/problems/maximum-sum-circular-subarray/

var maxSubarraySumCircular = function(nums) {
    let total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
    for (const x of nums) {
        curMax = Math.max(curMax + x, x);
        maxSum = Math.max(maxSum, curMax);
        curMin = Math.min(curMin + x, x);
        minSum = Math.min(minSum, curMin);
        total += x;
    }
    return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
};
