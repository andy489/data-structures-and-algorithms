// https://leetcode.com/problems/power-of-four/

// Solution: Bit Manipulation — O(1) time, O(1) space
var isPowerOfFour = function(n) {
    return n > 0 && (n & (n - 1)) === 0 && (n & 0x55555555) !== 0;
};
