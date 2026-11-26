# https://leetcode.com/problems/maximum-earnings-from-taxi/

class Solution:
    def maxTaxiEarnings(self, n: int, rides: list[list[int]]) -> int:
        from collections import defaultdict
        grouped = defaultdict(list)
        for s, e, t in rides:
            grouped[e].append((s, t + e - s))
        dp = [0] * (n + 1)
        for i in range(1, n + 1):
            dp[i] = dp[i - 1]
            for s, profit in grouped[i]:
                dp[i] = max(dp[i], dp[s] + profit)
        return dp[n]
