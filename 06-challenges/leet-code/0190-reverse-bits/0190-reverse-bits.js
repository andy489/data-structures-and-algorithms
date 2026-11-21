// https://leetcode.com/problems/reverse-bits/

// Bit manipulation — O(1) time, O(1) space
var reverseBits = function(n) {
    let result = 0;
    for (let i = 0; i < 32; i++) {
        result = ((result * 2) + (n & 1)) >>> 0;
        n >>>= 1;
    }
    return result >>> 0;
};
