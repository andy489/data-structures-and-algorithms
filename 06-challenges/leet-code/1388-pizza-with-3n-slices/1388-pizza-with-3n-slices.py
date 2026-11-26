# https://leetcode.com/problems/pizza-with-3n-slices/

class Solution:
    def maxSizeSlices(self, slices: list[int]) -> int:
        n = len(slices) // 3
        def pick(arr):
            m = len(arr)
            dp = [[0]*(n+1) for _ in range(m+1)]
            for i in range(1, m+1):
                for j in range(1, n+1):
                    dp[i][j] = max(dp[i-1][j], (dp[i-2][j-1] if i>=2 else 0) + arr[i-1])
            return dp[m][n]
        return max(pick(slices[:-1]), pick(slices[1:]))
