# https://leetcode.com/problems/max-area-of-island/

class Solution:
    def maxAreaOfIsland(self, grid: list) -> int:
        m, n = len(grid), len(grid[0])

        def dfs(r, c):
            if not (0 <= r < m and 0 <= c < n) or grid[r][c] == 0:
                return 0
            grid[r][c] = 0
            return 1 + dfs(r+1,c) + dfs(r-1,c) + dfs(r,c+1) + dfs(r,c-1)

        return max((dfs(i, j) for i in range(m) for j in range(n) if grid[i][j]), default=0)
