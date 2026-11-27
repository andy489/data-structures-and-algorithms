# https://leetcode.com/problems/pacific-atlantic-water-flow/

from collections import deque

class Solution:
    def pacificAtlantic(self, heights: list[list[int]]) -> list[list[int]]:
        m, n = len(heights), len(heights[0])
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        def bfs(seeds):
            visited = [[False] * n for _ in range(m)]
            queue = deque()
            for r, c in seeds:
                visited[r][c] = True
                queue.append((r, c))
            while queue:
                r, c = queue.popleft()
                for dr, dc in dirs:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < m and 0 <= nc < n and not visited[nr][nc] and heights[nr][nc] >= heights[r][c]:
                        visited[nr][nc] = True
                        queue.append((nr, nc))
            return visited

        pacific_seeds = [(r, 0) for r in range(m)] + [(0, c) for c in range(n)]
        atlantic_seeds = [(r, n - 1) for r in range(m)] + [(m - 1, c) for c in range(n)]

        pacific = bfs(pacific_seeds)
        atlantic = bfs(atlantic_seeds)

        return [[r, c] for r in range(m) for c in range(n) if pacific[r][c] and atlantic[r][c]]
