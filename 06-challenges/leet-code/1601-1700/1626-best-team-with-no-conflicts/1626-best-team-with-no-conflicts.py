# https://leetcode.com/problems/best-team-with-no-conflicts/

class Solution:
    def bestTeamScore(self, scores: list[int], ages: list[int]) -> int:
        players = sorted(zip(ages, scores))
        n = len(players)
        dp = [s for _, s in players]
        for i in range(n):
            for j in range(i):
                if players[j][1] <= players[i][1]:
                    dp[i] = max(dp[i], dp[j] + players[i][1])
        return max(dp)
