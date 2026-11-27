# https://leetcode.com/problems/k-inverse-pairs-array/

class Solution:
    def kInversePairs(self, n: int, k: int) -> int:
        MOD = 10 ** 9 + 7
        dp = [0] * (k + 1)
        dp[0] = 1
        for i in range(1, n + 1):
            next_dp = [0] * (k + 1)
            prefix = 0
            for j in range(k + 1):
                prefix = (prefix + dp[j]) % MOD
                if j >= i:
                    prefix = (prefix - dp[j - i] + MOD) % MOD
                next_dp[j] = prefix
            dp = next_dp
        return dp[k]
