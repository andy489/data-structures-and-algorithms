# https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd/

from math import gcd

class Solution:
    def subsequencePairCount(self, nums: list[int]) -> int:
        MOD = 10**9 + 7
        max_val = 201
        dp = [[0] * max_val for _ in range(max_val)]
        dp[0][0] = 1

        for x in nums:
            new_dp = [[0] * max_val for _ in range(max_val)]
            for g1 in range(max_val):
                for g2 in range(max_val):
                    if dp[g1][g2] == 0:
                        continue
                    val = dp[g1][g2]
                    # Skip x
                    new_dp[g1][g2] = (new_dp[g1][g2] + val) % MOD
                    # Add x to seq1
                    ng1 = x if g1 == 0 else gcd(g1, x)
                    new_dp[ng1][g2] = (new_dp[ng1][g2] + val) % MOD
                    # Add x to seq2
                    ng2 = x if g2 == 0 else gcd(g2, x)
                    new_dp[g1][ng2] = (new_dp[g1][ng2] + val) % MOD
            dp = new_dp

        return sum(dp[g][g] for g in range(1, max_val)) % MOD
