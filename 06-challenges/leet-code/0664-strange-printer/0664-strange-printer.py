# https://leetcode.com/problems/strange-printer/

class Solution:
    def strangePrinter(self, s: str) -> int:
        n = len(s)
        dp = [[0] * n for _ in range(n)]
        for i in range(n - 1, -1, -1):
            dp[i][i] = 1
            for j in range(i + 1, n):
                dp[i][j] = 1 + dp[i + 1][j]
                for k in range(i + 1, j + 1):
                    if s[k] == s[i]:
                        left = dp[i + 1][k - 1] if k > i + 1 else 0
                        dp[i][j] = min(dp[i][j], left + dp[k][j])
        return dp[0][n - 1]
