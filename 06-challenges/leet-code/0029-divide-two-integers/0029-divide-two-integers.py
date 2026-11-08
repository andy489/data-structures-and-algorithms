# https://leetcode.com/problems/divide-two-integers/

# Solution: Bit Shifting — O(log² n) time, O(1) space
class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        INT_MAX, INT_MIN = 2**31 - 1, -(2**31)
        # only overflow case: -2^31 / -1 = 2^31, which exceeds INT_MAX
        if dividend == INT_MIN and divisor == -1:
            return INT_MAX
        negative = (dividend > 0) != (divisor > 0)
        a, b = abs(dividend), abs(divisor)
        quotient = 0
        while a >= b:
            temp, multiple = b, 1
            # double temp until the next doubling would exceed a
            while a >= (temp << 1):
                temp <<= 1
                multiple <<= 1
            a -= temp
            quotient += multiple
        return -quotient if negative else quotient
