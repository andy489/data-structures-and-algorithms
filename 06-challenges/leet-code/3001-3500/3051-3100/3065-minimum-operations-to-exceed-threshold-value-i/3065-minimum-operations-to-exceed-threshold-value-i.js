// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/

var minOperations = function(nums, k) {
    return nums.filter(x => x < k).length;
};
