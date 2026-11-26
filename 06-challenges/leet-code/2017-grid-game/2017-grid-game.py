# https://leetcode.com/problems/grid-game/

class Solution:
    def gridGame(self, grid: list[list[int]]) -> int:
        n = len(grid[0])
        top = sum(grid[0])
        bot = 0
        res = float('inf')
        for i in range(n):
            top -= grid[0][i]
            res = min(res, max(top, bot))
            bot += grid[1][i]
        return res
