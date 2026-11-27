# https://leetcode.com/problems/unique-paths-iii/

class Solution:
    def uniquePathsIII(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        total = sum(grid[i][j] != -1 for i in range(m) for j in range(n))
        sr = sc = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    sr, sc = i, j

        self.ans = 0
        def dfs(r, c, visited):
            if grid[r][c] == 2:
                if visited == total - 1:
                    self.ans += 1
                return
            orig = grid[r][c]
            grid[r][c] = -1
            for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
                nr, nc = r+dr, c+dc
                if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] != -1:
                    dfs(nr, nc, visited + 1)
            grid[r][c] = orig

        dfs(sr, sc, 0)
        return self.ans
