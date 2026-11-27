// https://leetcode.com/problems/add-digits/

// Solution: Digital Root (Math) — O(1) time, O(1) space
var addDigits = function(num) {
    if (num === 0) return 0;
    return 1 + (num - 1) % 9;
};
