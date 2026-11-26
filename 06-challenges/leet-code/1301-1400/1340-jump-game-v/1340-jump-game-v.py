# https://leetcode.com/problems/jump-game-v/

from functools import lru_cache

class Solution:
    def maxJumps(self, arr: list[int], d: int) -> int:
        n = len(arr)
        @lru_cache(maxsize=None)
        def dp(i):
            res = 1
            for direction in [1, -1]:
                for k in range(1, d+1):
                    j = i + direction * k
                    if j < 0 or j >= n or arr[j] >= arr[i]:
                        break
                    res = max(res, 1 + dp(j))
            return res
        return max(dp(i) for i in range(n))
