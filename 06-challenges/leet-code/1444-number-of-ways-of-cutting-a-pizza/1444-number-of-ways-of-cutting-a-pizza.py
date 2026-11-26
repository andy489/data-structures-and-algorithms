# https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/

class Solution:
    def ways(self, pizza: list[str], k: int) -> int:
        MOD = 10**9 + 7
        R, C = len(pizza), len(pizza[0])
        suf = [[0]*(C+1) for _ in range(R+1)]
        for r in range(R-1, -1, -1):
            for c in range(C-1, -1, -1):
                suf[r][c] = (pizza[r][c]=='A') + suf[r+1][c] + suf[r][c+1] - suf[r+1][c+1]
        from functools import lru_cache
        @lru_cache(maxsize=None)
        def dp(r, c, p):
            if p == 1:
                return 1 if suf[r][c] > 0 else 0
            res = 0
            for nr in range(r+1, R):
                if suf[r][c] - suf[nr][c] > 0:
                    res = (res + dp(nr, c, p-1)) % MOD
            for nc in range(c+1, C):
                if suf[r][c] - suf[r][nc] > 0:
                    res = (res + dp(r, nc, p-1)) % MOD
            return res
        return dp(0, 0, k)
