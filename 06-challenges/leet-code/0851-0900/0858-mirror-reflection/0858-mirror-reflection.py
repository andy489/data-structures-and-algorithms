# https://leetcode.com/problems/mirror-reflection/

from math import gcd

class Solution:
    def mirrorReflection(self, p: int, q: int) -> int:
        g = gcd(p, q)
        m, n = p // g, q // g
        if m % 2 == 0:
            return 2
        if n % 2 == 0:
            return 0
        return 1
