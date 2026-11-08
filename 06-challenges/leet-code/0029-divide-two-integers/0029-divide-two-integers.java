// https://leetcode.com/problems/divide-two-integers/

// Solution: Bit Shifting — O(log² n) time, O(1) space
class Solution {
    public int divide(int dividend, int divisor) {
        // only overflow case: -2^31 / -1 = 2^31, which exceeds INT_MAX
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend > 0) == (divisor > 0) ? 1 : -1;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int quotient = 0;
        while (a >= b) {
            long temp = b, multiple = 1;
            // double temp until the next doubling would exceed a
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            a -= temp;
            quotient += multiple;
        }
        return sign * quotient;
    }
}
