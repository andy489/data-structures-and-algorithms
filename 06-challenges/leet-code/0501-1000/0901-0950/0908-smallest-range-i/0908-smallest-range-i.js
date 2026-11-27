// https://leetcode.com/problems/smallest-range-i/

var smallestRangeI = function(nums, k) {
    return Math.max(0, Math.max(...nums) - Math.min(...nums) - 2 * k);
};
