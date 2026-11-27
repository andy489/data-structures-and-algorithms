// https://leetcode.com/problems/plus-one/

// Solution: Right-to-Left Carry Propagation — O(n) time, O(1) space
var plusOne = function(digits) {
    for (let i = digits.length - 1; i >= 0; i--) {
        if (digits[i] < 9) {
            digits[i]++;
            return digits;
        }
        digits[i] = 0;
    }
    return [1, ...digits];
};
