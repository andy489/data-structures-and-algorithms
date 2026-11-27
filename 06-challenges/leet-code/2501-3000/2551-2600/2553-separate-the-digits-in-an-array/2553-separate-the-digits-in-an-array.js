// https://leetcode.com/problems/separate-the-digits-in-an-array/

// Solution: String Conversion — O(n * d) time, O(n * d) space
var separateDigits = function(nums) {
    return nums.flatMap(num => String(num).split('').map(Number));
};
