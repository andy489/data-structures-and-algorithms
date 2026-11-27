// https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/

/**
 * @param {number[]} nums
 * @return {number}
 */
var maxAdjacentDistance = function(nums) {
    const n = nums.length;
    let maxDiff = Math.abs(nums[0] - nums[n - 1]);
    for (let i = 1; i < n; i++) {
        maxDiff = Math.max(maxDiff, Math.abs(nums[i] - nums[i - 1]));
    }
    return maxDiff;
};
