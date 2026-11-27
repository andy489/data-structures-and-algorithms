# https://leetcode.com/problems/paint-house-iv/

class Solution:
    def minCost(self, n: int, cost: list[list[int]]) -> int:
        INF = float('inf')
        # dp[c1][c2] = min cost with left=c1, right=c2 (c1 != c2)
        dp = [[INF] * 3 for _ in range(3)]
        for c1 in range(3):
            for c2 in range(3):
                if c1 != c2:
                    dp[c1][c2] = cost[0][c1] + cost[n-1][c2]
        for i in range(1, n // 2):
            ndp = [[INF] * 3 for _ in range(3)]
            for nc1 in range(3):
                for nc2 in range(3):
                    if nc1 == nc2:
                        continue
                    for pc1 in range(3):
                        if pc1 == nc1:
                            continue
                        for pc2 in range(3):
                            if pc2 == nc2 or dp[pc1][pc2] == INF:
                                continue
                            val = dp[pc1][pc2] + cost[i][nc1] + cost[n-1-i][nc2]
                            if val < ndp[nc1][nc2]:
                                ndp[nc1][nc2] = val
            dp = ndp
        return min(dp[c1][c2] for c1 in range(3) for c2 in range(3))
