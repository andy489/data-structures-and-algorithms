// https://leetcode.com/problems/bitwise-and-of-numbers-range/

// Solution: Common Prefix (Bit Shift) — O(log n) time, O(1) space
var rangeBitwiseAnd = function(left, right) {
    let shift = 0;

    while (left !== right) {
        left >>= 1;
        right >>= 1;
        shift++;
    }

    return left << shift;
};

// Solution 2: Brian Kernighan Trick — O(log n) time, O(1) space
var rangeBitwiseAnd2 = function(left, right) {
    while (right > left) {
        right &= (right - 1);
    }

    return right;
};
