# https://leetcode.com/problems/regions-cut-by-slashes/

class Solution:
    def regionsBySlashes(self, grid: list[str]) -> int:
        n = len(grid)
        g = [[0] * (n * 3) for _ in range(n * 3)]
        for i in range(n):
            for j in range(n):
                if grid[i][j] == '/':
                    g[i*3][j*3+2] = g[i*3+1][j*3+1] = g[i*3+2][j*3] = 1
                elif grid[i][j] == '\\':
                    g[i*3][j*3] = g[i*3+1][j*3+1] = g[i*3+2][j*3+2] = 1

        def dfs(r, c):
            if 0 <= r < n*3 and 0 <= c < n*3 and g[r][c] == 0:
                g[r][c] = 1
                dfs(r+1, c); dfs(r-1, c); dfs(r, c+1); dfs(r, c-1)

        regions = 0
        for i in range(n * 3):
            for j in range(n * 3):
                if g[i][j] == 0:
                    dfs(i, j)
                    regions += 1
        return regions
