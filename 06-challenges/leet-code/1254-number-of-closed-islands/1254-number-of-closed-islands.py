# https://leetcode.com/problems/number-of-closed-islands/

class Solution:
    def closedIsland(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        def dfs(i, j):
            if not (0 <= i < m and 0 <= j < n) or grid[i][j] != 0: return
            grid[i][j] = 1
            for di, dj in [(1,0),(-1,0),(0,1),(0,-1)]: dfs(i+di, j+dj)
        for i in range(m): dfs(i, 0); dfs(i, n-1)
        for j in range(n): dfs(0, j); dfs(m-1, j)
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0: dfs(i, j); count += 1
        return count
