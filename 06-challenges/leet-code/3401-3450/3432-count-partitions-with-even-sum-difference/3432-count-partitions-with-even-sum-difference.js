// https://leetcode.com/problems/count-partitions-with-even-sum-difference/
/**
 * @param {number[]} nums
 * @return {number}
 */
var countPartitions = function(nums) {
    const total = nums.reduce((s, x) => s + x, 0);
    if (total % 2 !== 0) {
        return 0;
    }
    return nums.length - 1;
};
