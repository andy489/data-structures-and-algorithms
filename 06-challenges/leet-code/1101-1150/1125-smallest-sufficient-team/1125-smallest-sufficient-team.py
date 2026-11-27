# https://leetcode.com/problems/smallest-sufficient-team/

class Solution:
    def smallestSufficientTeam(self, req_skills: list[str], people: list[list[str]]) -> list[int]:
        skill_index = {s: i for i, s in enumerate(req_skills)}
        n = len(req_skills)
        full = (1 << n) - 1
        dp = [None] * (full + 1)
        dp[0] = []

        for i, skills in enumerate(people):
            pmask = 0
            for s in skills:
                pmask |= 1 << skill_index[s]
            for mask in range(full, -1, -1):
                if dp[mask] is None:
                    continue
                nxt = mask | pmask
                if dp[nxt] is None or len(dp[nxt]) > len(dp[mask]) + 1:
                    dp[nxt] = dp[mask] + [i]

        return dp[full]
