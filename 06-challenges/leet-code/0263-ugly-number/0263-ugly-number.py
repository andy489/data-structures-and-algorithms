# https://leetcode.com/problems/ugly-number/

class Solution:
    def isUgly(self, n: int) -> bool:
        if n <= 0:
            return False
        for f in (2, 3, 5):
            while n % f == 0:
                n //= f
        return n == 1
