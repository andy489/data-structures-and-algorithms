# https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/

class Solution:
    def maximumScore(self, nums: list[int], multipliers: list[int]) -> int:
        n, m = len(nums), len(multipliers)
        dp = [[0] * (m + 1) for _ in range(m + 1)]
        for i in range(m - 1, -1, -1):
            for l in range(i + 1):
                r = n - 1 - (i - l)
                pick_left = multipliers[i] * nums[l] + dp[i + 1][l + 1]
                pick_right = multipliers[i] * nums[r] + dp[i + 1][l]
                dp[i][l] = max(pick_left, pick_right)
        return dp[0][0]
