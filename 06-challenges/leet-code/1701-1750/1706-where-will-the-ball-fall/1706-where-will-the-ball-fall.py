# https://leetcode.com/problems/where-will-the-ball-fall/

class Solution:
    def findBall(self, grid: list[list[int]]) -> list[int]:
        m, n = len(grid), len(grid[0])
        result = []
        for j in range(n):
            col = j
            for row in range(m):
                direction = grid[row][col]
                nxt = col + direction
                if nxt < 0 or nxt >= n or grid[row][nxt] != direction:
                    col = -1
                    break
                col = nxt
            result.append(col)
        return result
