# https://leetcode.com/problems/stone-game-ii/

from functools import lru_cache

class Solution:
    def stoneGameII(self, piles: list[int]) -> int:
        n = len(piles)
        suffix = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            suffix[i] = suffix[i + 1] + piles[i]

        @lru_cache(maxsize=None)
        def dp(i, m):
            if i + 2 * m >= n:
                return suffix[i]
            return max(suffix[i] - dp(i + x, max(m, x)) for x in range(1, 2 * m + 1))

        return dp(0, 1)
