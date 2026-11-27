# https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/

class Solution:
    def maximumAmount(self, coins: list[list[int]]) -> int:
        m, n = len(coins), len(coins[0])
        NEG_INF = float('-inf')
        # dp[i][j][k] = max coins at (i,j) with k neutralizations used (0,1,2)
        dp = [[[NEG_INF] * 3 for _ in range(n)] for _ in range(m)]
        for k in range(3):
            dp[0][0][k] = 0 if (coins[0][0] < 0 and k > 0) else coins[0][0]
        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    continue
                for k in range(3):
                    prev = NEG_INF
                    if i > 0 and dp[i-1][j][k] != NEG_INF:
                        prev = max(prev, dp[i-1][j][k])
                    if j > 0 and dp[i][j-1][k] != NEG_INF:
                        prev = max(prev, dp[i][j-1][k])
                    if prev == NEG_INF:
                        continue
                    dp[i][j][k] = max(dp[i][j][k], prev + coins[i][j])
                    if coins[i][j] < 0 and k > 0:
                        pk = k - 1
                        prev_k = NEG_INF
                        if i > 0:
                            prev_k = max(prev_k, dp[i-1][j][pk])
                        if j > 0:
                            prev_k = max(prev_k, dp[i][j-1][pk])
                        if prev_k != NEG_INF:
                            dp[i][j][k] = max(dp[i][j][k], prev_k)
        return dp[m-1][n-1][2]
