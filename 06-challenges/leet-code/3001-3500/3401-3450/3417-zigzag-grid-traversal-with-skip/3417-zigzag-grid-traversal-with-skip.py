# https://leetcode.com/problems/zigzag-grid-traversal-with-skip/

class Solution:
    def zigzagTraversal(self, grid: list[list[int]]) -> list[int]:
        m, n = len(grid), len(grid[0])
        result = []
        skip = 0
        for i in range(m):
            row = range(n) if i % 2 == 0 else range(n - 1, -1, -1)
            for j in row:
                if skip % 2 == 0:
                    result.append(grid[i][j])
                skip += 1
        return result
