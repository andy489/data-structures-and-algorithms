# https://leetcode.com/problems/maximum-trailing-zeros-in-a-cornered-path/

class Solution:
    def maxTrailingZeros(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])

        def factors(v: int, p: int) -> int:
            cnt = 0
            while v % p == 0:
                v //= p
                cnt += 1
            return cnt

        r2 = [[0] * (n + 1) for _ in range(m)]
        r5 = [[0] * (n + 1) for _ in range(m)]
        c2 = [[0] * n for _ in range(m + 1)]
        c5 = [[0] * n for _ in range(m + 1)]

        for i in range(m):
            for j in range(n):
                tw = factors(grid[i][j], 2)
                fi = factors(grid[i][j], 5)
                r2[i][j + 1] = r2[i][j] + tw
                r5[i][j + 1] = r5[i][j] + fi

        for j in range(n):
            for i in range(m):
                tw = factors(grid[i][j], 2)
                fi = factors(grid[i][j], 5)
                c2[i + 1][j] = c2[i][j] + tw
                c5[i + 1][j] = c5[i][j] + fi

        ans = 0
        for i in range(m):
            for j in range(n):
                left2 = r2[i][j + 1]
                left5 = r5[i][j + 1]
                right2 = r2[i][n] - r2[i][j]
                right5 = r5[i][n] - r5[i][j]
                up2 = c2[i + 1][j]
                up5 = c5[i + 1][j]
                down2 = c2[m][j] - c2[i][j]
                down5 = c5[m][j] - c5[i][j]

                ans = max(ans,
                          min(left2 + up2, left5 + up5),
                          min(left2 + down2, left5 + down5),
                          min(right2 + up2, right5 + up5),
                          min(right2 + down2, right5 + down5))
        return ans
