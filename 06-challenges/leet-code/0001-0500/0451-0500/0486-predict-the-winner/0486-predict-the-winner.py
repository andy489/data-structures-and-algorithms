# https://leetcode.com/problems/predict-the-winner/

class Solution:
    def predictTheWinner(self, nums: list[int]) -> bool:
        n = len(nums)
        dp = nums[:]
        for length in range(2, n + 1):
            for i in range(n - length + 1):
                j = i + length - 1
                dp[i] = max(nums[i] - dp[i + 1], nums[j] - dp[i])
        return dp[0] >= 0
