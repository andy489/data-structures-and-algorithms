# https://leetcode.com/problems/distinct-subsequences/

# Solution 1: 2D DP — O(m·n) time, O(m·n) space
class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        m, n = len(t), len(s)
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        for j in range(n + 1):
            dp[0][j] = 1

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                dp[i][j] = dp[i][j - 1]
                if s[j - 1] == t[i - 1]:
                    dp[i][j] += dp[i - 1][j - 1]

        return dp[m][n]


# Solution 2: 1D DP (Space-Optimised) — O(m·n) time, O(m) space
class Solution2:
    def numDistinct(self, s: str, t: str) -> int:
        m = len(t)
        dp = [0] * (m + 1)
        dp[0] = 1

        for c in s:
            for i in range(m, 0, -1):
                if c == t[i - 1]:
                    dp[i] += dp[i - 1]

        return dp[m]
