# https://leetcode.com/problems/minimum-xor-path-in-a-grid/

import heapq

class Solution:
    def minXorPath(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dist = [[float('inf')] * n for _ in range(m)]
        dist[0][0] = grid[0][0]
        pq = [(grid[0][0], 0, 0)]
        while pq:
            xor, r, c = heapq.heappop(pq)
            if xor > dist[r][c]:
                continue
            for dr, dc in [(0, 1), (1, 0)]:
                nr, nc = r + dr, c + dc
                if nr < m and nc < n:
                    nx = xor ^ grid[nr][nc]
                    if nx < dist[nr][nc]:
                        dist[nr][nc] = nx
                        heapq.heappush(pq, (nx, nr, nc))
        return dist[m - 1][n - 1]
