# https://leetcode.com/problems/maximize-palindrome-length-from-subsequences/

class Solution:
    def longestPalindrome(self, word1: str, word2: str) -> int:
        s = word1 + word2
        n1, length = len(word1), len(s)
        dp = [[0] * length for _ in range(length)]
        for i in range(length):
            dp[i][i] = 1
        ans = 0
        for size in range(2, length + 1):
            for i in range(length - size + 1):
                j = i + size - 1
                if s[i] == s[j]:
                    dp[i][j] = dp[i + 1][j - 1] + 2
                    if i < n1 <= j:
                        ans = max(ans, dp[i][j])
                else:
                    dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
        return ans
