# https://leetcode.com/problems/wildcard-matching/

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m, n = len(s), len(p)
        dp = [[False] * (n + 1) for _ in range(m + 1)]
        dp[0][0] = True
        for j in range(1, n + 1):
            if p[j - 1] == '*':
                dp[0][j] = dp[0][j - 1]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                pc = p[j - 1]
                if pc == s[i - 1] or pc == '?':
                    dp[i][j] = dp[i - 1][j - 1]
                elif pc == '*':
                    dp[i][j] = dp[i - 1][j] or dp[i][j - 1]
        return dp[m][n]
