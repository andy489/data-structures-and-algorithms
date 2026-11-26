# https://leetcode.com/problems/score-after-flipping-matrix/

class Solution:
    def matrixScore(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        for r in range(m):
            if grid[r][0] == 0:
                for c in range(n):
                    grid[r][c] ^= 1
        score = 0
        for c in range(n):
            ones = sum(grid[r][c] for r in range(m))
            score += max(ones, m - ones) * (1 << (n - 1 - c))
        return score
