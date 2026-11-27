# https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

class Solution:
    def numRollsToTarget(self, n: int, k: int, target: int) -> int:
        MOD = 10 ** 9 + 7
        dp = [0] * (target + 1)
        dp[0] = 1
        for _ in range(n):
            next_dp = [0] * (target + 1)
            for s in range(1, target + 1):
                for f in range(1, k + 1):
                    if f <= s:
                        next_dp[s] = (next_dp[s] + dp[s - f]) % MOD
            dp = next_dp
        return dp[target]
