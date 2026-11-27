// https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k/

var maxSubarraySum = function(nums, k) {
    const minByRem = new Array(k).fill(Infinity);
    minByRem[0] = 0;

    let prefix = 0, maxSum = -Infinity;
    for (let i = 1; i <= nums.length; i++) {
        prefix += nums[i - 1];
        const r = i % k;
        if (minByRem[r] !== Infinity) {
            maxSum = Math.max(maxSum, prefix - minByRem[r]);
        }
        minByRem[r] = Math.min(minByRem[r], prefix);
    }
    return maxSum;
};
