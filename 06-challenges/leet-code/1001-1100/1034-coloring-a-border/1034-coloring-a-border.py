# https://leetcode.com/problems/coloring-a-border/

class Solution:
    def colorBorder(self, grid: list[list[int]], row: int, col: int, color: int) -> list[list[int]]:
        from collections import deque
        m, n = len(grid), len(grid[0])
        orig = grid[row][col]
        visited = [[False]*n for _ in range(m)]
        component = []
        q = deque([(row, col)])
        visited[row][col] = True
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        while q:
            r, c = q.popleft()
            component.append((r, c))
            for dr, dc in dirs:
                nr, nc = r+dr, c+dc
                if 0 <= nr < m and 0 <= nc < n and not visited[nr][nc] and grid[nr][nc] == orig:
                    visited[nr][nc] = True
                    q.append((nr, nc))
        for r, c in component:
            border = r == 0 or r == m-1 or c == 0 or c == n-1
            if not border:
                border = any(grid[r+dr][c+dc] != orig for dr, dc in dirs)
            if border:
                grid[r][c] = color
        return grid
