# https://leetcode.com/problems/closest-divisors/

import math

class Solution:
    def closestDivisors(self, num: int) -> list[int]:
        best = [1, num+2]
        for target in [num+1, num+2]:
            for a in range(int(math.isqrt(target)), 0, -1):
                if target % a == 0:
                    b = target // a
                    if b - a < best[1] - best[0]:
                        best = [a, b]
                    break
        return best
