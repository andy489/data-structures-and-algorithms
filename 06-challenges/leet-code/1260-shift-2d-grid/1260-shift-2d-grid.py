# https://leetcode.com/problems/shift-2d-grid/

class Solution:
    def shiftGrid(self, grid: list[list[int]], k: int) -> list[list[int]]:
        m, n = len(grid), len(grid[0])
        flat = [grid[i][j] for i in range(m) for j in range(n)]
        total = m * n
        k %= total
        flat = flat[-k:] + flat[:-k]
        return [flat[i*n:(i+1)*n] for i in range(m)]
