// https://leetcode.com/problems/divide-two-integers/

// Solution: Bit Shifting — O(log² n) time, O(1) space
var divide = function(dividend, divisor) {
    const INT_MAX = 2 ** 31 - 1, INT_MIN = -(2 ** 31);
    // only overflow case: -2^31 / -1 = 2^31, which exceeds INT_MAX
    if (dividend === INT_MIN && divisor === -1) return INT_MAX;
    const negative = (dividend > 0) !== (divisor > 0);
    let a = Math.abs(dividend), b = Math.abs(divisor);
    let quotient = 0;
    while (a >= b) {
        let temp = b, multiple = 1;
        // double temp until the next doubling would exceed a
        while (a >= (temp << 1)) {
            temp <<= 1;
            multiple <<= 1;
        }
        a -= temp;
        quotient += multiple;
    }
    return negative ? -quotient : quotient;
};
