# https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0/

class Solution:
    def minOperations(self, n: int) -> int:
        ops = 0
        while n > 0:
            if n & 1 == 0:
                n >>= 1
            elif n & 3 == 3:
                # Two consecutive 1-bits: carry up
                n += 1
                ops += 1
            else:
                # Single 1-bit: subtract
                n -= 1
                ops += 1
        return ops
