# https://leetcode.com/problems/unique-paths-ii/

class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: list[list[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        dp = [0] * n
        dp[0] = 0 if obstacleGrid[0][0] else 1
        for j in range(1, n):
            dp[j] = dp[j - 1] if obstacleGrid[0][j] == 0 else 0
        for i in range(1, m):
            if obstacleGrid[i][0] == 1:
                dp[0] = 0
            for j in range(1, n):
                dp[j] = dp[j] + dp[j - 1] if obstacleGrid[i][j] == 0 else 0
        return dp[n - 1]
