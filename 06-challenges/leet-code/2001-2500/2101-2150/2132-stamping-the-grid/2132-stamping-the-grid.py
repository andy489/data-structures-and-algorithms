# https://leetcode.com/problems/stamping-the-grid/
class Solution:
    def possibleToStamp(self, grid: list, stampHeight: int, stampWidth: int) -> bool:
        m, n = len(grid), len(grid[0])
        # Build prefix sum of grid
        ps = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                ps[i][j] = grid[i-1][j-1] + ps[i-1][j] + ps[i][j-1] - ps[i-1][j-1]

        def query(ps, r1, c1, r2, c2):
            return ps[r2][c2] - ps[r1-1][c2] - ps[r2][c1-1] + ps[r1-1][c1-1]

        # Mark valid stamp placements
        stamps = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m - stampHeight + 2):
            for j in range(1, n - stampWidth + 2):
                r2, c2 = i + stampHeight - 1, j + stampWidth - 1
                if query(ps, i, j, r2, c2) == 0:
                    stamps[i][j] += 1

        # Build prefix sum of stamp placements
        sps = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                sps[i][j] = stamps[i][j] + sps[i-1][j] + sps[i][j-1] - sps[i-1][j-1]

        # Check every empty cell is covered
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if grid[i-1][j-1] == 0:
                    r1 = max(1, i - stampHeight + 1)
                    c1 = max(1, j - stampWidth + 1)
                    if query(sps, r1, c1, i, j) == 0:
                        return False
        return True
