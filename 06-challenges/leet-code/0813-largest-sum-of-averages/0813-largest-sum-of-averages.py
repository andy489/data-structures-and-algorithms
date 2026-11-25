# https://leetcode.com/problems/largest-sum-of-averages/

class Solution:
    def largestSumOfAverages(self, nums: list[int], k: int) -> float:
        n = len(nums)
        prefix = [0] * (n + 1)
        for i, x in enumerate(nums):
            prefix[i + 1] = prefix[i] + x
        dp = [prefix[i] / i for i in range(n + 1)]
        for _ in range(k - 1):
            for j in range(n, 0, -1):
                for m in range(j):
                    dp[j] = max(dp[j], dp[m] + (prefix[j] - prefix[m]) / (j - m))
        return dp[n]
