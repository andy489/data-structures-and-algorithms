# https://leetcode.com/problems/count-paths-with-the-given-xor-value/

class Solution:
    def countPathsWithXorValue(self, grid: list[list[int]], k: int) -> int:
        MOD = 10 ** 9 + 7
        m, n = len(grid), len(grid[0])
        dp = [[[0] * 16 for _ in range(n)] for _ in range(m)]
        dp[0][0][grid[0][0]] = 1
        for j in range(1, n):
            for v in range(16):
                if dp[0][j - 1][v]:
                    dp[0][j][v ^ grid[0][j]] = (dp[0][j][v ^ grid[0][j]] + dp[0][j - 1][v]) % MOD
        for i in range(1, m):
            for v in range(16):
                if dp[i - 1][0][v]:
                    dp[i][0][v ^ grid[i][0]] = (dp[i][0][v ^ grid[i][0]] + dp[i - 1][0][v]) % MOD
        for i in range(1, m):
            for j in range(1, n):
                for v in range(16):
                    nxt = v ^ grid[i][j]
                    dp[i][j][nxt] = (dp[i][j][nxt] + dp[i - 1][j][v] + dp[i][j - 1][v]) % MOD
        return dp[m - 1][n - 1][k]
