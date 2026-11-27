# https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/

class Solution:
    def numWays(self, words: list[str], target: str) -> int:
        MOD = 10 ** 9 + 7
        L, m = len(words[0]), len(target)
        cnt = [[0] * 26 for _ in range(L)]
        for w in words:
            for k, ch in enumerate(w):
                cnt[k][ord(ch) - ord('a')] += 1
        dp = [0] * (m + 1)
        dp[0] = 1
        for k in range(L):
            for i in range(min(k, m - 1), -1, -1):
                c = ord(target[i]) - ord('a')
                dp[i + 1] = (dp[i + 1] + dp[i] * cnt[k][c]) % MOD
        return dp[m]
