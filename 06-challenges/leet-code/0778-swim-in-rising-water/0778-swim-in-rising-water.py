# https://leetcode.com/problems/swim-in-rising-water/

import heapq

class Solution:
    def swimInWater(self, grid: list[list[int]]) -> int:
        n = len(grid)
        heap = [(grid[0][0], 0, 0)]
        visited = [[False] * n for _ in range(n)]
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        while heap:
            t, r, c = heapq.heappop(heap)
            if visited[r][c]:
                continue
            visited[r][c] = True
            if r == n - 1 and c == n - 1:
                return t
            for dr, dc in dirs:
                nr, nc = r + dr, c + dc
                if 0 <= nr < n and 0 <= nc < n and not visited[nr][nc]:
                    heapq.heappush(heap, (max(t, grid[nr][nc]), nr, nc))
        return -1
