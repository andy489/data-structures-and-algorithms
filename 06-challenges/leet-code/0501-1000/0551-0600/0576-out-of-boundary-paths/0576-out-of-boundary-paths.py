class Solution:
    def findPaths(self, m: int, n: int, maxMove: int, startRow: int, startColumn: int) -> int:
        MOD = 10 ** 9 + 7
        dp = [[0] * n for _ in range(m)]
        dp[startRow][startColumn] = 1
        ans = 0
        for _ in range(maxMove):
            nxt = [[0] * n for _ in range(m)]
            for i in range(m):
                for j in range(n):
                    if dp[i][j] == 0:
                        continue
                    for di, dj in ((0, 1), (0, -1), (1, 0), (-1, 0)):
                        ni, nj = i + di, j + dj
                        if 0 <= ni < m and 0 <= nj < n:
                            nxt[ni][nj] = (nxt[ni][nj] + dp[i][j]) % MOD
                        else:
                            ans = (ans + dp[i][j]) % MOD
            dp = nxt
        return ans
