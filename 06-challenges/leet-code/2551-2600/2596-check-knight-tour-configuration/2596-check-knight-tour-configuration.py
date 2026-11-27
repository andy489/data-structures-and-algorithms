# https://leetcode.com/problems/check-knight-tour-configuration/
class Solution:
    def checkValidGrid(self, grid: list[list[int]]) -> bool:
        if grid[0][0] != 0:
            return False
        n = len(grid)
        positions = [None] * (n * n)
        for r in range(n):
            for c in range(n):
                positions[grid[r][c]] = (r, c)
        for m in range(n * n - 1):
            r1, c1 = positions[m]
            r2, c2 = positions[m + 1]
            dr, dc = abs(r2 - r1), abs(c2 - c1)
            if not ((dr == 1 and dc == 2) or (dr == 2 and dc == 1)):
                return False
        return True
