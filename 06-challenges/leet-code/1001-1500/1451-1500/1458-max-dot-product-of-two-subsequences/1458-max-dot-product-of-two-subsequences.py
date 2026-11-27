# https://leetcode.com/problems/max-dot-product-of-two-subsequences/

class Solution:
    def maxDotProduct(self, nums1: list[int], nums2: list[int]) -> int:
        n, m = len(nums1), len(nums2)
        dp = [[float('-inf')] * (m+1) for _ in range(n+1)]
        for i in range(1, n+1):
            for j in range(1, m+1):
                prod = nums1[i-1] * nums2[j-1]
                dp[i][j] = max(dp[i-1][j], dp[i][j-1], prod + max(0, dp[i-1][j-1]))
        return dp[n][m]
