# https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/

from functools import lru_cache

class Solution:
    def minDays(self, n: int) -> int:
        @lru_cache(maxsize=None)
        def dp(x: int) -> int:
            if x <= 1:
                return x
            return 1 + min(x % 2 + dp(x // 2), x % 3 + dp(x // 3))
        return dp(n)
