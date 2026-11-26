# https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/

class Solution:
    def minDifficulty(self, jd: list[int], d: int) -> int:
        n = len(jd)
        if n < d:
            return -1
        INF = float('inf')
        dp = [[INF]*(n+1) for _ in range(d+1)]
        dp[0][0] = 0
        for k in range(1, d+1):
            for j in range(k, n+1):
                mx = 0
                for i in range(j-1, k-2, -1):
                    mx = max(mx, jd[i])
                    if dp[k-1][i] < INF:
                        dp[k][j] = min(dp[k][j], dp[k-1][i] + mx)
        return dp[d][n] if dp[d][n] < INF else -1
