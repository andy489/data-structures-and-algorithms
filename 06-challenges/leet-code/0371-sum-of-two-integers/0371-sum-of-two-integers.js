// https://leetcode.com/problems/sum-of-two-integers/

// Solution: Bit Manipulation — O(1) time, O(1) space
var getSum = function(a, b) {
    while (b !== 0) {
        const carry = (a & b) << 1;
        a = a ^ b;
        b = carry;
    }
    return a;
};
