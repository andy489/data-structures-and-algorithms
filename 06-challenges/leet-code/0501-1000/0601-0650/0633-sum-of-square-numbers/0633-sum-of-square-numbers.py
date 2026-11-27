# https://leetcode.com/problems/sum-of-square-numbers/

import math

class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        a, b = 0, int(math.isqrt(c))
        while a <= b:
            s = a * a + b * b
            if s == c:
                return True
            elif s < c:
                a += 1
            else:
                b -= 1
        return False
