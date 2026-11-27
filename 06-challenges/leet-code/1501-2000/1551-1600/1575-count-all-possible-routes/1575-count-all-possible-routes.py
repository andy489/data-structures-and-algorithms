# https://leetcode.com/problems/count-all-possible-routes/

from functools import lru_cache

class Solution:
    def countRoutes(self, locations: list[int], start: int, finish: int, fuel: int) -> int:
        MOD = 10 ** 9 + 7

        @lru_cache(maxsize=None)
        def dp(cur: int, remaining: int) -> int:
            if remaining < 0:
                return 0
            res = 1 if cur == finish else 0
            for nxt in range(len(locations)):
                if nxt != cur:
                    cost = abs(locations[nxt] - locations[cur])
                    if remaining >= cost:
                        res = (res + dp(nxt, remaining - cost)) % MOD
            return res

        return dp(start, fuel)
