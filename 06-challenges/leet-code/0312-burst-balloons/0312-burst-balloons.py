# https://leetcode.com/problems/burst-balloons/

class Solution:
    def maxCoins(self, nums: list[int]) -> int:
        arr = [1] + nums + [1]
        m = len(arr)
        dp = [[0] * m for _ in range(m)]
        for length in range(2, m):
            for l in range(m - length):
                r = l + length
                for k in range(l + 1, r):
                    dp[l][r] = max(dp[l][r], dp[l][k] + arr[l] * arr[k] * arr[r] + dp[k][r])
        return dp[0][m - 1]
