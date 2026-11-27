# https://leetcode.com/problems/minimum-cost-to-partition-a-binary-string/

from functools import lru_cache

class Solution:
    def minimumCost(self, s: str, encCost: int, flatCost: int) -> int:
        n = len(s)
        prefix = [0] * (n + 1)
        for i, c in enumerate(s):
            prefix[i + 1] = prefix[i] + int(c)

        @lru_cache(maxsize=None)
        def solve(l: int, r: int) -> int:
            length = r - l + 1
            ones = prefix[r + 1] - prefix[l]
            cost = flatCost if ones == 0 else length * ones * encCost
            if length % 2 != 0:
                return cost
            mid = (l + r) // 2
            split = solve(l, mid) + solve(mid + 1, r)
            return min(cost, split)

        return solve(0, n - 1)
