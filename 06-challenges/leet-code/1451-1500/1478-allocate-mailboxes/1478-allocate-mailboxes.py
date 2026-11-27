# https://leetcode.com/problems/allocate-mailboxes/

class Solution:
    def minDistance(self, houses: list[int], k: int) -> int:
        houses.sort()
        n = len(houses)
        cost = [[0]*n for _ in range(n)]
        for i in range(n):
            for j in range(i, n):
                mid = (i+j)//2
                for x in range(i, j+1):
                    cost[i][j] += abs(houses[x] - houses[mid])
        INF = float('inf')
        dp = [[INF]*(n+1) for _ in range(k+1)]
        dp[0][0] = 0
        for i in range(1, k+1):
            for j in range(1, n+1):
                for p in range(i-1, j):
                    if dp[i-1][p] < INF:
                        dp[i][j] = min(dp[i][j], dp[i-1][p] + cost[p][j-1])
        return dp[k][n]
