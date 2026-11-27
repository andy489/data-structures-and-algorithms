# https://leetcode.com/problems/maximum-path-intersection-sum-in-a-grid/
class Solution:
    def maxPathIntersectionSum(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        steps = m + n - 2
        NEG_INF = float('-inf')
        # dp[r1][r2]: max shared sum when player1 at row r1, player2 at row r2 at current step
        # player1 col = s - r1, player2 col = s - m + 1 + r2
        dp = [[NEG_INF] * m for _ in range(m)]
        # s=0: player1 at (0,0), player2 at (m-1,0)
        shared = grid[0][0] if 0 == m - 1 else 0
        dp[0][m - 1] = shared

        for s in range(1, steps + 1):
            ndp = [[NEG_INF] * m for _ in range(m)]
            r1_min = max(0, s - (n - 1))
            r1_max = min(s, m - 1)
            p2r_min = max(0, m - 1 - s)
            p2r_max = min(m - 1, m - 1 + s - (s - (n - 1)) if s >= n - 1 else m - 1)
            p2r_max = min(p2r_max, m - 1)
            # col2 = s - m + 1 + r2 must be in [0, n-1]
            # r2 >= m - 1 - s (already p2r_min) and r2 <= m - 1 + n - 1 - s
            p2r_max = min(m - 1, m - 1 + n - 1 - s)
            if p2r_max < 0:
                continue
            for r1 in range(r1_min, r1_max + 1):
                c1 = s - r1
                if c1 < 0 or c1 >= n:
                    continue
                for r2 in range(max(p2r_min, 0), p2r_max + 1):
                    c2 = s - m + 1 + r2
                    if c2 < 0 or c2 >= n:
                        continue
                    best = NEG_INF
                    for pr1 in range(max(0, r1 - 1), r1 + 1):
                        for pr2 in range(r2, min(m, r2 + 2)):
                            if dp[pr1][pr2] != NEG_INF:
                                best = max(best, dp[pr1][pr2])
                    if best != NEG_INF:
                        add = grid[r1][c1] if r1 == r2 and c1 == c2 else 0
                        ndp[r1][r2] = max(ndp[r1][r2], best + add)
            dp = ndp

        return dp[m - 1][0]
