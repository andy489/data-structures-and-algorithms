// https://leetcode.com/problems/minimum-operations-to-make-array-non-decreasing/
/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumOperations = function(nums) {
    let total = 0;
    for (let i = 0; i < nums.length - 1; i++) {
        if (nums[i] > nums[i + 1]) {
            total += nums[i] - nums[i + 1];
        }
    }
    return total;
};
