// https://leetcode.com/problems/limit-occurrences-in-sorted-array/
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var limitOccurrences = function(nums, k) {
    const result = [];
    let count = 0;
    for (let i = 0; i < nums.length; i++) {
        if (i === 0 || nums[i] !== nums[i - 1]) {
            count = 1;
        } else {
            count++;
        }
        if (count <= k) {
            result.push(nums[i]);
        }
    }
    return result;
};
