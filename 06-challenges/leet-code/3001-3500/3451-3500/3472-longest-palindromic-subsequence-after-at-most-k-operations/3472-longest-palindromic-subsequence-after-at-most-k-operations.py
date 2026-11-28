# https://leetcode.com/problems/longest-palindromic-subsequence-after-at-most-k-operations/

class Solution:
    def longestPalindromicSubsequence(self, s: str, k: int) -> int:
        n = len(s)
        # dp[i][j][b] = LPS of s[i..j] with at most b operations
        dp = [[[0] * (k + 1) for _ in range(n)] for _ in range(n)]
        for i in range(n):
            for b in range(k + 1):
                dp[i][i][b] = 1

        for length in range(2, n + 1):
            for i in range(n - length + 1):
                j = i + length - 1
                for b in range(k + 1):
                    diff = abs(ord(s[i]) - ord(s[j]))
                    cost = min(diff, 26 - diff)
                    best = max(dp[i + 1][j][b], dp[i][j - 1][b])
                    if b >= cost:
                        inner = 0 if length == 2 else dp[i + 1][j - 1][b - cost]
                        best = max(best, inner + 2)
                    dp[i][j][b] = best

        return dp[0][n - 1][k]
