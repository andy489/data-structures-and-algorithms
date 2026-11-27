# https://leetcode.com/problems/simplified-fractions/

from math import gcd

class Solution:
    def simplifiedFractions(self, n: int) -> list[str]:
        return [f"{num}/{d}" for d in range(2, n+1) for num in range(1, d) if gcd(num, d) == 1]
