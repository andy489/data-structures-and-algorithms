# https://leetcode.com/problems/surface-area-of-3d-shapes/

class Solution:
    def surfaceArea(self, grid: list[list[int]]) -> int:
        n = len(grid)
        ans = 0
        for i in range(n):
            for j in range(n):
                if grid[i][j]:
                    ans += 4 * grid[i][j] + 2
                if i > 0: ans -= 2 * min(grid[i][j], grid[i-1][j])
                if j > 0: ans -= 2 * min(grid[i][j], grid[i][j-1])
        return ans
