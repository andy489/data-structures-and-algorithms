# https://leetcode.com/problems/maximal-network-rank/

class Solution:
    def maximalNetworkRank(self, n: int, roads: list[list[int]]) -> int:
        degree = [0] * n
        connected = [[False] * n for _ in range(n)]
        for a, b in roads:
            degree[a] += 1
            degree[b] += 1
            connected[a][b] = connected[b][a] = True
        max_rank = 0
        for i in range(n):
            for j in range(i + 1, n):
                rank = degree[i] + degree[j] - (1 if connected[i][j] else 0)
                max_rank = max(max_rank, rank)
        return max_rank
