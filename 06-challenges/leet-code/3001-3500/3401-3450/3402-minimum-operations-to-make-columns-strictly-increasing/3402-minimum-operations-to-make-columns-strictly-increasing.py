# https://leetcode.com/problems/minimum-operations-to-make-columns-strictly-increasing/
class Solution:
    def minimumOperations(self, grid: list[list[int]]) -> int:
        ops = 0
        m, n = len(grid), len(grid[0])
        for j in range(n):
            prev = grid[0][j]
            for i in range(1, m):
                if grid[i][j] <= prev:
                    ops += prev + 1 - grid[i][j]
                    prev = prev + 1
                else:
                    prev = grid[i][j]
        return ops
