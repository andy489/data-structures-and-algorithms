# https://leetcode.com/problems/count-fertile-pyramids-in-a-land/

class Solution:
    def countPyramids(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        res = 0
        dp = [[0]*n for _ in range(m)]
        for i in range(m-1, -1, -1):
            for j in range(n):
                if not grid[i][j]:
                    dp[i][j] = 0
                elif i == m-1 or j == 0 or j == n-1:
                    dp[i][j] = 1
                else:
                    dp[i][j] = min(dp[i+1][j-1], dp[i+1][j], dp[i+1][j+1]) + 1
                res += dp[i][j] - 1
        for i in range(m):
            for j in range(n):
                if not grid[i][j]:
                    dp[i][j] = 0
                elif i == 0 or j == 0 or j == n-1:
                    dp[i][j] = 1
                else:
                    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1]) + 1
                res += dp[i][j] - 1
        return res
