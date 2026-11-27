// https://leetcode.com/problems/concatenate-array-with-reverse/

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var concatenateArray = function(nums) {
    return [...nums, ...nums.slice().reverse()];
};
