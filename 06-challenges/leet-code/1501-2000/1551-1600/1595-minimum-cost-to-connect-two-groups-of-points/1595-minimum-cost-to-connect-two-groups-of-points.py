# https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/

class Solution:
    def connectTwoGroups(self, cost: list[list[int]]) -> int:
        m, n = len(cost), len(cost[0])
        full = (1 << n) - 1
        min_cost_right = [min(cost[i][j] for i in range(m)) for j in range(n)]
        dp = [float('inf')] * (1 << n)
        dp[0] = 0
        for i in range(m):
            ndp = [float('inf')] * (1 << n)
            for mask in range(1 << n):
                if dp[mask] == float('inf'):
                    continue
                for j in range(n):
                    nmask = mask | (1 << j)
                    ndp[nmask] = min(ndp[nmask], dp[mask] + cost[i][j])
            dp = ndp
        result = float('inf')
        for mask in range(1 << n):
            if dp[mask] == float('inf'):
                continue
            extra = sum(min_cost_right[j] for j in range(n) if not (mask >> j & 1))
            result = min(result, dp[mask] + extra)
        return result
