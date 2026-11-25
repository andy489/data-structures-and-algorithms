# https://leetcode.com/problems/projection-area-of-3d-shapes/

class Solution:
    def projectionArea(self, grid: list[list[int]]) -> int:
        n = len(grid)
        xy = sum(1 for r in grid for v in r if v > 0)
        yz = sum(max(grid[i]) for i in range(n))
        zx = sum(max(grid[i][j] for i in range(n)) for j in range(n))
        return xy + yz + zx
