# https://leetcode.com/problems/multi-source-flood-fill/
from collections import deque
from typing import List


class Solution:
    def floodFill(self, n: int, m: int, sources: List[List[int]]) -> List[List[int]]:
        grid = [[0] * m for _ in range(n)]
        dist = [[-1] * m for _ in range(n)]
        queue = deque()
        for r, c, color in sources:
            grid[r][c] = color
            dist[r][c] = 0
            queue.append((r, c))
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        while queue:
            r, c = queue.popleft()
            for dr, dc in dirs:
                nr, nc = r + dr, c + dc
                if 0 <= nr < n and 0 <= nc < m:
                    new_dist = dist[r][c] + 1
                    if dist[nr][nc] == -1:
                        dist[nr][nc] = new_dist
                        grid[nr][nc] = grid[r][c]
                        queue.append((nr, nc))
                    elif dist[nr][nc] == new_dist:
                        grid[nr][nc] = max(grid[nr][nc], grid[r][c])
        return grid
