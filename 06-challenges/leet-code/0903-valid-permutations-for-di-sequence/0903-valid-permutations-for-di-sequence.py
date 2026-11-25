# https://leetcode.com/problems/valid-permutations-for-di-sequence/

class Solution:
    def numPermsDISequence(self, s: str) -> int:
        MOD = 10 ** 9 + 7
        dp = [1]
        for ch in s:
            n = len(dp)
            ndp = [0] * (n + 1)
            if ch == 'I':
                prefix = 0
                for j in range(n):
                    prefix = (prefix + dp[j]) % MOD
                    ndp[j + 1] = prefix
            else:
                suffix = 0
                for j in range(n - 1, -1, -1):
                    suffix = (suffix + dp[j]) % MOD
                    ndp[j] = suffix
            dp = ndp
        return sum(dp) % MOD
