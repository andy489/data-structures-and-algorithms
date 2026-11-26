# https://leetcode.com/problems/integer-replacement/

class Solution:
    def integerReplacement(self, n: int) -> int:
        ops = 0
        while n != 1:
            if n % 2 == 0:
                n >>= 1
            elif n == 3 or (n & 3) == 1:
                n -= 1
            else:
                n += 1
            ops += 1
        return ops
