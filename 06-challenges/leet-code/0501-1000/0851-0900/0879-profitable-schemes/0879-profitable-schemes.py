# https://leetcode.com/problems/profitable-schemes/

class Solution:
    def profitableSchemes(self, n: int, minProfit: int, group: list[int], profit: list[int]) -> int:
        MOD = 10**9 + 7
        dp = [[0] * (minProfit + 1) for _ in range(n + 1)]
        dp[0][0] = 1
        for g, pr in zip(group, profit):
            for j in range(n, g - 1, -1):
                for p in range(minProfit, -1, -1):
                    dp[j][min(p + pr, minProfit)] = (dp[j][min(p + pr, minProfit)] + dp[j - g][p]) % MOD
        return sum(dp[j][minProfit] for j in range(n + 1)) % MOD
