# https://leetcode.com/problems/spiral-matrix-iii/

class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> list[list[int]]:
        dirs = [(0,1),(1,0),(0,-1),(-1,0)]
        result = []
        r, c, d, steps = rStart, cStart, 0, 1
        while len(result) < rows * cols:
            for _ in range(2):
                for _ in range(steps):
                    if 0 <= r < rows and 0 <= c < cols:
                        result.append([r, c])
                    r += dirs[d][0]; c += dirs[d][1]
                d = (d + 1) % 4
            steps += 1
        return result
