// https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0/

/**
 * @param {number} n
 * @return {number}
 */
var minOperations = function(n) {
    let ops = 0;
    while (n > 0) {
        if ((n & 1) === 0) {
            n >>= 1;
        } else if ((n & 3) === 3) {
            // Two consecutive 1-bits: carry up
            n += 1;
            ops++;
        } else {
            // Single 1-bit: subtract
            n -= 1;
            ops++;
        }
    }
    return ops;
};
