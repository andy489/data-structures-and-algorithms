# https://leetcode.com/problems/path-with-minimum-effort/

import heapq

class Solution:
    def minimumEffortPath(self, heights: list[list[int]]) -> int:
        rows, cols = len(heights), len(heights[0])
        effort = [[float('inf')] * cols for _ in range(rows)]
        effort[0][0] = 0
        pq = [(0, 0, 0)]
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        while pq:
            e, r, c = heapq.heappop(pq)
            if e > effort[r][c]:
                continue
            if r == rows - 1 and c == cols - 1:
                return e
            for dr, dc in dirs:
                nr, nc = r + dr, c + dc
                if 0 <= nr < rows and 0 <= nc < cols:
                    ne = max(e, abs(heights[nr][nc] - heights[r][c]))
                    if ne < effort[nr][nc]:
                        effort[nr][nc] = ne
                        heapq.heappush(pq, (ne, nr, nc))
        return effort[rows - 1][cols - 1]
