# https://leetcode.com/problems/shortest-bridge/

from collections import deque

class Solution:
    def shortestBridge(self, grid: list) -> int:
        n = len(grid)
        q = deque()

        def dfs(r, c):
            if 0 <= r < n and 0 <= c < n and grid[r][c] == 1:
                grid[r][c] = 2
                q.append((r, c))
                dfs(r+1, c); dfs(r-1, c); dfs(r, c+1); dfs(r, c-1)

        found = False
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    dfs(i, j)
                    found = True
                    break
            if found:
                break

        steps = 0
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        while q:
            for _ in range(len(q)):
                r, c = q.popleft()
                for dr, dc in dirs:
                    nr, nc = r+dr, c+dc
                    if 0 <= nr < n and 0 <= nc < n:
                        if grid[nr][nc] == 1:
                            return steps
                        if grid[nr][nc] == 0:
                            grid[nr][nc] = 2
                            q.append((nr, nc))
            steps += 1
        return -1
