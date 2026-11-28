# https://leetcode.com/problems/length-of-longest-v-shaped-diagonal-segment/

class Solution:
    def lenOfVDiagonal(self, grid: list[list[int]]) -> int:
        n, m = len(grid), len(grid[0])
        dirs = [(1, 1), (1, -1), (-1, 1), (-1, -1)]
        # Clockwise 90-degree turn: (1,1)->(1,-1), (1,-1)->(-1,-1), (-1,1)->(1,1), (-1,-1)->(-1,1)
        clockwise = {0: 1, 1: 3, 2: 0, 3: 2}
        # dp[r][c][d][t]: max segment length at (r,c), direction d, t=0 no turn, t=1 turned
        dp = [[[[0] * 2 for _ in range(4)] for _ in range(m)] for _ in range(n)]
        ans = 0

        # Initialize cells with value 1 as segment starts
        for r in range(n):
            for c in range(m):
                if grid[r][c] == 1:
                    for d in range(4):
                        dp[r][c][d][0] = 1
                        dp[r][c][d][1] = 1
                    ans = max(ans, 1)

        for _ in range(2):  # Two passes to handle turn propagation
            for r in range(n):
                for c in range(m):
                    for d in range(4):
                        dr, dc = dirs[d]
                        pr, pc = r - dr, c - dc
                        if 0 <= pr < n and 0 <= pc < m:
                            # Extend without turn
                            if dp[pr][pc][d][0] > 0:
                                expected = 2 if dp[pr][pc][d][0] % 2 == 1 else 0
                                if grid[r][c] == expected:
                                    new_len = dp[pr][pc][d][0] + 1
                                    if new_len > dp[r][c][d][0]:
                                        dp[r][c][d][0] = new_len
                                        ans = max(ans, new_len)
                            # Extend after turn (from direction clockwise[d])
                            td = clockwise[d]
                            if dp[pr][pc][td][1] > 0:
                                expected2 = 2 if dp[pr][pc][td][1] % 2 == 1 else 0
                                if grid[r][c] == expected2:
                                    new_len = dp[pr][pc][td][1] + 1
                                    if new_len > dp[r][c][d][1]:
                                        dp[r][c][d][1] = new_len
                                        ans = max(ans, new_len)
        return ans
