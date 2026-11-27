// https://leetcode.com/problems/sum-of-variable-length-subarrays/

/**
 * @param {number[]} nums
 * @return {number}
 */
var subarraySum = function(nums) {
    const n = nums.length;
    const prefix = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) prefix[i + 1] = prefix[i] + nums[i];
    let total = 0;
    for (let i = 0; i < n; i++) {
        const start = Math.max(0, i - nums[i]);
        total += prefix[i + 1] - prefix[start];
    }
    return total;
};
