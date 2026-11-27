# https://leetcode.com/problems/longest-string-chain/

class Solution:
    def longestStrChain(self, words: list[str]) -> int:
        words.sort(key=len)
        dp = {}
        res = 1
        for w in words:
            dp[w] = 1
            for i in range(len(w)):
                prev = w[:i] + w[i+1:]
                if prev in dp:
                    dp[w] = max(dp[w], dp[prev] + 1)
            res = max(res, dp[w])
        return res
