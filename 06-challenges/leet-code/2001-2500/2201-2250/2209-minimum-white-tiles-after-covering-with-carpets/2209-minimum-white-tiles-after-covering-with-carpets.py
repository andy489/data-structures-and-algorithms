# https://leetcode.com/problems/minimum-white-tiles-after-covering-with-carpets/
class Solution:
    def minimumWhiteTiles(self, floor: str, numCarpets: int, carpetLen: int) -> int:
        n = len(floor)
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + (1 if floor[i] == '1' else 0)

        INF = float('inf')
        dp = [[INF] * (numCarpets + 1) for _ in range(n + 1)]
        for j in range(numCarpets + 1):
            dp[0][j] = 0

        for i in range(1, n + 1):
            for j in range(numCarpets + 1):
                dp[i][j] = dp[i - 1][j] + (1 if floor[i - 1] == '1' else 0)
                if j > 0:
                    start = max(0, i - carpetLen)
                    dp[i][j] = min(dp[i][j], dp[start][j - 1])

        return dp[n][numCarpets]
