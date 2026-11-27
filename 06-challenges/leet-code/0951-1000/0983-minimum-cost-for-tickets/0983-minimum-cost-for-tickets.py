# https://leetcode.com/problems/minimum-cost-for-tickets/

class Solution:
    def mincostTickets(self, days: list[int], costs: list[int]) -> int:
        travel = set(days)
        last = days[-1]
        dp = [0] * (last + 1)
        for i in range(1, last + 1):
            if i not in travel:
                dp[i] = dp[i - 1]
            else:
                dp[i] = min(
                    dp[i - 1] + costs[0],
                    dp[max(0, i - 7)] + costs[1],
                    dp[max(0, i - 30)] + costs[2]
                )
        return dp[last]
