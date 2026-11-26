# https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/

class Solution:
    def maxProductPath(self, grid: list[list[int]]) -> int:
        MOD = 10**9 + 7
        m, n = len(grid), len(grid[0])
        dp_max = [[0] * n for _ in range(m)]
        dp_min = [[0] * n for _ in range(m)]
        dp_max[0][0] = dp_min[0][0] = grid[0][0]
        for i in range(1, m):
            dp_max[i][0] = dp_min[i][0] = dp_max[i - 1][0] * grid[i][0]
        for j in range(1, n):
            dp_max[0][j] = dp_min[0][j] = dp_max[0][j - 1] * grid[0][j]
        for i in range(1, m):
            for j in range(1, n):
                v = grid[i][j]
                candidates = [
                    dp_max[i - 1][j] * v, dp_min[i - 1][j] * v,
                    dp_max[i][j - 1] * v, dp_min[i][j - 1] * v,
                ]
                dp_max[i][j] = max(candidates)
                dp_min[i][j] = min(candidates)
        ans = dp_max[m - 1][n - 1]
        return -1 if ans < 0 else int(ans % MOD)
