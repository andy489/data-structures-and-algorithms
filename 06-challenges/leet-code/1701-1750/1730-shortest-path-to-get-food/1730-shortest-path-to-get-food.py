# https://leetcode.com/problems/shortest-path-to-get-food/

class Solution:
    def getFood(self, grid: list[list[str]]) -> int:
        from collections import deque
        m, n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '*':
                    start = (i, j)
        queue = deque([(start[0], start[1], 0)])
        visited = {start}
        for r, c, dist in queue:
            for dr, dc in ((0,1),(0,-1),(1,0),(-1,0)):
                nr, nc = r + dr, c + dc
                if 0 <= nr < m and 0 <= nc < n and (nr, nc) not in visited and grid[nr][nc] != 'X':
                    if grid[nr][nc] == '#':
                        return dist + 1
                    visited.add((nr, nc))
                    queue.append((nr, nc, dist + 1))
        return -1
