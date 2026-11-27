# https://leetcode.com/problems/guess-number-higher-or-lower-ii/

class Solution:
    def getMoneyAmount(self, n: int) -> int:
        dp = [[0] * (n + 2) for _ in range(n + 2)]
        for length in range(2, n + 1):
            for i in range(1, n - length + 2):
                j = i + length - 1
                dp[i][j] = float('inf')
                for k in range(i, j + 1):
                    cost = k + max(
                        dp[i][k - 1] if k > i else 0,
                        dp[k + 1][j] if k < j else 0
                    )
                    dp[i][j] = min(dp[i][j], cost)
        return dp[1][n]
