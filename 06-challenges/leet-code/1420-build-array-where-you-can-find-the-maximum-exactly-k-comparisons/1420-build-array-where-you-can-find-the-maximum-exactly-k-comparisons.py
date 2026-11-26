# https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/

class Solution:
    def numOfArrays(self, n: int, m: int, k: int) -> int:
        MOD = 10**9 + 7
        dp = [[[0]*(k+1) for _ in range(m+1)] for _ in range(n+1)]
        for j in range(1, m+1):
            dp[1][j][1] = 1
        for i in range(1, n):
            for j in range(1, m+1):
                for c in range(1, k+1):
                    if not dp[i][j][c]:
                        continue
                    dp[i+1][j][c] = (dp[i+1][j][c] + dp[i][j][c] * j) % MOD
                    for v in range(j+1, m+1):
                        dp[i+1][v][c+1] = (dp[i+1][v][c+1] + dp[i][j][c]) % MOD
        return sum(dp[n][j][k] for j in range(1, m+1)) % MOD
