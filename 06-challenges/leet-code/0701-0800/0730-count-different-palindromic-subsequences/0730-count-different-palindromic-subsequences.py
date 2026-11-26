# https://leetcode.com/problems/count-different-palindromic-subsequences/

class Solution:
    def countPalindromicSubsequences(self, s: str) -> int:
        MOD = 10 ** 9 + 7
        n = len(s)
        dp = [[0] * n for _ in range(n)]
        for i in range(n):
            dp[i][i] = 1
        for length in range(2, n + 1):
            for i in range(n - length + 1):
                j = i + length - 1
                for c in 'abcd':
                    l, r = i, j
                    while l <= j and s[l] != c:
                        l += 1
                    while r >= i and s[r] != c:
                        r -= 1
                    if l > r:
                        continue
                    elif l == r:
                        dp[i][j] += 1
                    elif l + 1 == r:
                        dp[i][j] += 2
                    else:
                        dp[i][j] += dp[l + 1][r - 1] + 2
                dp[i][j] %= MOD
        return dp[0][n - 1]
