# https://leetcode.com/problems/count-servers-that-communicate/

class Solution:
    def countServers(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        row = [sum(grid[i]) for i in range(m)]
        col = [sum(grid[i][j] for i in range(m)) for j in range(n)]
        return sum(grid[i][j] for i in range(m) for j in range(n) if grid[i][j] and (row[i] > 1 or col[j] > 1))
