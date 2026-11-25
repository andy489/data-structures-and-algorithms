# https://leetcode.com/problems/cherry-pickup/

class Solution:
    def cherryPickup(self, grid: list[list[int]]) -> int:
        n = len(grid)
        NEG = float('-inf')
        dp = [[NEG] * n for _ in range(n)]
        dp[0][0] = grid[0][0]
        for t in range(1, 2 * n - 1):
            ndp = [[NEG] * n for _ in range(n)]
            for r1 in range(max(0, t - n + 1), min(t, n - 1) + 1):
                c1 = t - r1
                if grid[r1][c1] == -1:
                    continue
                for r2 in range(r1, min(t, n - 1) + 1):
                    c2 = t - r2
                    if grid[r2][c2] == -1:
                        continue
                    cherries = grid[r1][c1] + (grid[r2][c2] if r1 != r2 else 0)
                    best = NEG
                    for dr1 in range(2):
                        for dr2 in range(2):
                            pr1, pr2 = r1 - dr1, r2 - dr2
                            if pr1 >= 0 and pr2 >= 0 and dp[pr1][pr2] != NEG:
                                best = max(best, dp[pr1][pr2] + cherries)
                    ndp[r1][r2] = best
            dp = ndp
        return max(0, dp[n - 1][n - 1])
