# https://leetcode.com/problems/minimum-falling-path-sum-ii/

class Solution:
    def minFallingPathSum(self, grid: list[list[int]]) -> int:
        n = len(grid)
        dp = grid[0][:]
        for i in range(1, n):
            min1 = min2 = float('inf')
            min_col = -1
            for j, v in enumerate(dp):
                if v < min1: min2, min1, min_col = min1, v, j
                elif v < min2: min2 = v
            dp = [grid[i][j] + (min2 if j == min_col else min1) for j in range(n)]
        return min(dp)
