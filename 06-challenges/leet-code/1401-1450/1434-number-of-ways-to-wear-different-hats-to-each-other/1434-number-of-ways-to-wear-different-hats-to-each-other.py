# https://leetcode.com/problems/number-of-ways-to-wear-different-hats-to-each-other/

class Solution:
    def numberWays(self, hats: list[list[int]]) -> int:
        from collections import defaultdict
        MOD = 10**9 + 7
        n = len(hats)
        hat_people = defaultdict(list)
        for p, pref in enumerate(hats):
            for h in pref:
                hat_people[h].append(p)
        dp = [0] * (1 << n)
        dp[0] = 1
        for h in range(1, 41):
            for mask in range((1 << n) - 1, -1, -1):
                for p in hat_people[h]:
                    if not (mask >> p & 1):
                        dp[mask | (1 << p)] = (dp[mask | (1 << p)] + dp[mask]) % MOD
        return dp[(1 << n) - 1]
