# https://leetcode.com/problems/01-matrix/
# Solution: Multi-source BFS — O(m·n) time, O(m·n) space
from collections import deque

class Solution:
    def updateMatrix(self, mat: list[list[int]]) -> list[list[int]]:
        rows, cols = len(mat), len(mat[0])
        dist = [[0] * cols for _ in range(rows)]
        queue = deque()
        for r in range(rows):
            for c in range(cols):
                if mat[r][c] == 0:
                    queue.append((r, c))
                else:
                    dist[r][c] = float('inf')
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        while queue:
            r, c = queue.popleft()
            for dr, dc in dirs:
                nr, nc = r + dr, c + dc
                if 0 <= nr < rows and 0 <= nc < cols and dist[nr][nc] > dist[r][c] + 1:
                    dist[nr][nc] = dist[r][c] + 1
                    queue.append((nr, nc))
        return dist
