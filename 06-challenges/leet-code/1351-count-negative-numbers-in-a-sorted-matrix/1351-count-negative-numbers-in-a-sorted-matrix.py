# https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

class Solution:
    def countNegatives(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        i, j, count = 0, n-1, 0
        while i < m and j >= 0:
            if grid[i][j] < 0:
                count += m - i
                j -= 1
            else:
                i += 1
        return count
