# https://leetcode.com/problems/paint-house-iii/

class Solution:
    def minCost(self, houses: list[int], cost: list[list[int]], m: int, n: int, target: int) -> int:
        INF = float('inf')
        dp = [[[INF]*(target+1) for _ in range(n+1)] for _ in range(m)]
        for c in range(1, n+1):
            if houses[0] == 0 or houses[0] == c:
                dp[0][c][1] = cost[0][c-1] if houses[0] == 0 else 0
        for i in range(1, m):
            for c in range(1, n+1):
                if houses[i] != 0 and houses[i] != c:
                    continue
                pc = cost[i][c-1] if houses[i] == 0 else 0
                for k in range(1, min(i+2, target+1)):
                    for prev_c in range(1, n+1):
                        if prev_c == c and dp[i-1][prev_c][k] < INF:
                            dp[i][c][k] = min(dp[i][c][k], dp[i-1][prev_c][k] + pc)
                        if prev_c != c and k > 1 and dp[i-1][prev_c][k-1] < INF:
                            dp[i][c][k] = min(dp[i][c][k], dp[i-1][prev_c][k-1] + pc)
        ans = min(dp[m-1][c][target] for c in range(1, n+1))
        return -1 if ans == INF else ans
