# https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/

from typing import List
import heapq

class Solution:
    def minimumTime(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        if grid[0][1] > 1 and grid[1][0] > 1:
            return -1

        dist = [[float('inf')] * n for _ in range(m)]
        dist[0][0] = 0
        heap = [(0, 0, 0)]  # (time, row, col)
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        while heap:
            t, r, c = heapq.heappop(heap)
            if r == m - 1 and c == n - 1:
                return t
            if t > dist[r][c]:
                continue
            for dr, dc in dirs:
                nr, nc = r + dr, c + dc
                if 0 <= nr < m and 0 <= nc < n:
                    nt = t + 1
                    if nt < grid[nr][nc]:
                        diff = grid[nr][nc] - nt
                        nt = grid[nr][nc] + (0 if diff % 2 == 0 else 1)
                    if nt < dist[nr][nc]:
                        dist[nr][nc] = nt
                        heapq.heappush(heap, (nt, nr, nc))

        return -1
