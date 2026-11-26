# https://leetcode.com/problems/cherry-pickup-ii/

class Solution:
    def cherryPickup(self, grid: list[list[int]]) -> int:
        R, C = len(grid), len(grid[0])
        dp = [[[-1]*C for _ in range(C)] for _ in range(R)]
        dp[0][0][C-1] = grid[0][0] + (grid[0][C-1] if C > 1 else 0)
        for r in range(R-1):
            for c1 in range(C):
                for c2 in range(C):
                    if dp[r][c1][c2] < 0:
                        continue
                    for d1 in (-1, 0, 1):
                        for d2 in (-1, 0, 1):
                            nc1, nc2 = c1+d1, c2+d2
                            if 0 <= nc1 < C and 0 <= nc2 < C:
                                cherries = grid[r+1][nc1] + (grid[r+1][nc2] if nc1 != nc2 else 0)
                                dp[r+1][nc1][nc2] = max(dp[r+1][nc1][nc2], dp[r][c1][c2]+cherries)
        return max(v for row in dp[R-1] for v in row if v >= 0)
