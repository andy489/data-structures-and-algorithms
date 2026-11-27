# https://leetcode.com/problems/minimum-cost-to-split-into-ones/

class Solution:
    def minimumCost(self, n: int) -> int:
        dp = [0] * (n + 1)
        dp[1] = 0
        for x in range(2, n + 1):
            dp[x] = float('inf')
            for a in range(1, x):
                b = x - a
                cost = a * b + dp[a] + dp[b]
                dp[x] = min(dp[x], cost)
        return dp[n]
