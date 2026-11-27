# https://leetcode.com/problems/integer-break/

class Solution:
    def integerBreak(self, n: int) -> int:
        if n == 2:
            return 1
        if n == 3:
            return 2
        product = 1
        while n > 4:
            product *= 3
            n -= 3
        return product * n
