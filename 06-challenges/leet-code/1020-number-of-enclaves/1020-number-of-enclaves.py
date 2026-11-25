# https://leetcode.com/problems/number-of-enclaves/

class Solution:
    def numEnclaves(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        def flood(r, c):
            if r < 0 or r >= m or c < 0 or c >= n or grid[r][c] != 1:
                return
            grid[r][c] = 0
            flood(r+1,c); flood(r-1,c); flood(r,c+1); flood(r,c-1)
        for i in range(m):
            flood(i, 0); flood(i, n-1)
        for j in range(n):
            flood(0, j); flood(m-1, j)
        return sum(cell for row in grid for cell in row)
