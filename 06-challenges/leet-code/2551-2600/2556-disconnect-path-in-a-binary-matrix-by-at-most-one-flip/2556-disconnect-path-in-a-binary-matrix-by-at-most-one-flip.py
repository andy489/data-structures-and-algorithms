# https://leetcode.com/problems/disconnect-path-in-a-binary-matrix-by-at-most-one-flip/

# Solution: Two DFS Passes — O(m*n) time, O(m*n) space
class Solution:
    def isPossibleToCutPath(self, grid: list[list[int]]) -> bool:
        m, n = len(grid), len(grid[0])

        def dfs(r: int, c: int) -> bool:
            if r == m - 1 and c == n - 1:
                return True
            if r >= m or c >= n or grid[r][c] == 0:
                return False
            grid[r][c] = 0
            return dfs(r + 1, c) or dfs(r, c + 1)

        if not dfs(0, 0):
            return True
        grid[0][0] = 1
        grid[m - 1][n - 1] = 1
        return not dfs(0, 0)
