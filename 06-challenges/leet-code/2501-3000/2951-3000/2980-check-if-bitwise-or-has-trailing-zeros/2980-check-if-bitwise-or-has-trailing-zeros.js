// https://leetcode.com/problems/check-if-bitwise-or-has-trailing-zeros/
var hasTrailingZeros = function(nums) {
    return nums.filter(x => (x & 1) === 0).length >= 2;
};
