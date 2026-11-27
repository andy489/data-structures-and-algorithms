// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

var findNumbers = function(nums) {
    return nums.filter(x => String(x).length % 2 === 0).length;
};
