# https://leetcode.com/problems/dungeon-game/

# DP from bottom-right — O(m*n) time, O(n) space
class Solution:
    def calculateMinimumHP(self, dungeon: list[list[int]]) -> int:
        m, n = len(dungeon), len(dungeon[0])
        dp = [float('inf')] * (n + 1)
        dp[n - 1] = 1
        for i in range(m - 1, -1, -1):
            new_dp = [float('inf')] * (n + 1)
            new_dp[n - 1] = 1
            for j in range(n - 1, -1, -1):
                need = min(dp[j], new_dp[j + 1])
                new_dp[j] = max(1, need - dungeon[i][j])
            dp = new_dp
        return dp[0]
