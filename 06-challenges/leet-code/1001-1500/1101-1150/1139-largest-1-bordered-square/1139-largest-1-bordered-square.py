# https://leetcode.com/problems/largest-1-bordered-square/

class Solution:
    def largest1BorderedSquare(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        hor = [[0] * n for _ in range(m)]
        ver = [[0] * n for _ in range(m)]

        for i in range(m):
            for j in range(n):
                if grid[i][j]:
                    hor[i][j] = (hor[i][j - 1] if j > 0 else 0) + 1
                    ver[i][j] = (ver[i - 1][j] if i > 0 else 0) + 1

        for s in range(min(m, n), 0, -1):
            for i in range(s - 1, m):
                for j in range(s - 1, n):
                    if (hor[i][j] >= s and ver[i][j] >= s
                            and hor[i - s + 1][j] >= s
                            and ver[i][j - s + 1] >= s):
                        return s * s
        return 0
