# https://leetcode.com/problems/maximum-points-tourist-can-earn/

class Solution:
    def maxScore(self, n: int, k: int, stayScore: list[list[int]], travelScore: list[list[int]]) -> int:
        dp = [stayScore[0][c] for c in range(n)]
        for day in range(1, k):
            new_dp = [0] * n
            for dest in range(n):
                new_dp[dest] = dp[dest] + stayScore[day][dest]
                for prev in range(n):
                    if prev != dest:
                        new_dp[dest] = max(new_dp[dest], dp[prev] + travelScore[prev][dest])
            dp = new_dp
        return max(dp)
