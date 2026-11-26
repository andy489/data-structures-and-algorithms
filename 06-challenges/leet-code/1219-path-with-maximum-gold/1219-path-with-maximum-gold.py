# https://leetcode.com/problems/path-with-maximum-gold/

class Solution:
    def getMaximumGold(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        def dfs(i, j):
            if not (0 <= i < m and 0 <= j < n) or grid[i][j] == 0:
                return 0
            gold, grid[i][j] = grid[i][j], 0
            best = gold + max(dfs(i+1,j), dfs(i-1,j), dfs(i,j+1), dfs(i,j-1))
            grid[i][j] = gold
            return best
        return max(dfs(i,j) for i in range(m) for j in range(n))
