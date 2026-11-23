# https://leetcode.com/problems/trapping-rain-water-ii/

import heapq

class Solution:
    def trapRainWater(self, heightMap: list[list[int]]) -> int:
        m, n = len(heightMap), len(heightMap[0])
        if m < 3 or n < 3:
            return 0
        visited = [[False] * n for _ in range(m)]
        heap = []
        for r in range(m):
            for c in range(n):
                if r == 0 or r == m - 1 or c == 0 or c == n - 1:
                    heapq.heappush(heap, (heightMap[r][c], r, c))
                    visited[r][c] = True
        water = 0
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        while heap:
            level, r, c = heapq.heappop(heap)
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < m and 0 <= nc < n and not visited[nr][nc]:
                    visited[nr][nc] = True
                    water += max(0, level - heightMap[nr][nc])
                    heapq.heappush(heap, (max(level, heightMap[nr][nc]), nr, nc))
        return water
