# https://leetcode.com/problems/magic-squares-in-grid/

class Solution:
    def numMagicSquaresInside(self, grid: list[list[int]]) -> int:
        rows, cols = len(grid), len(grid[0])

        def is_magic(r, c):
            vals = [grid[r+i][c+j] for i in range(3) for j in range(3)]
            if sorted(vals) != list(range(1, 10)):
                return False
            for i in range(3):
                if sum(grid[r+i][c+j] for j in range(3)) != 15:
                    return False
                if sum(grid[r+j][c+i] for j in range(3)) != 15:
                    return False
            if grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2] != 15:
                return False
            if grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c] != 15:
                return False
            return True

        return sum(is_magic(r, c) for r in range(rows - 2) for c in range(cols - 2))
