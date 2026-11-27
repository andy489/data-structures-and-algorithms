# https://leetcode.com/problems/max-increase-to-keep-city-skyline/

class Solution:
    def maxIncreaseKeepingSkyline(self, grid: list[list[int]]) -> int:
        row_max = [max(row) for row in grid]
        col_max = [max(grid[r][c] for r in range(len(grid))) for c in range(len(grid[0]))]
        return sum(min(row_max[i], col_max[j]) - grid[i][j]
                   for i in range(len(grid)) for j in range(len(grid[0])))
