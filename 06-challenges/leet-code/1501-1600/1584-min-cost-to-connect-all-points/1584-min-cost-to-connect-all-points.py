# https://leetcode.com/problems/min-cost-to-connect-all-points/

class Solution:
    def minCostConnectPoints(self, points: list[list[int]]) -> int:
        n = len(points)
        min_dist = [float('inf')] * n
        in_mst = [False] * n
        min_dist[0] = 0
        total = 0
        for _ in range(n):
            u = min((i for i in range(n) if not in_mst[i]), key=lambda i: min_dist[i])
            in_mst[u] = True
            total += min_dist[u]
            for v in range(n):
                if not in_mst[v]:
                    dist = abs(points[u][0] - points[v][0]) + abs(points[u][1] - points[v][1])
                    min_dist[v] = min(min_dist[v], dist)
        return total
