# https://leetcode.com/problems/smallest-good-base/

import math

class Solution:
    def smallestGoodBase(self, n: str) -> str:
        num = int(n)
        max_m = int(math.log2(num))

        for m in range(max_m, 1, -1):
            k = int(num ** (1.0 / (m - 1)))
            if k >= 2 and self._geometric_sum(k, m) == num:
                return str(k)
        return str(num - 1)

    def _geometric_sum(self, k: int, m: int) -> int:
        total = 0
        power = 1
        for _ in range(m):
            total += power
            power *= k
        return total
