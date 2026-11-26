# https://leetcode.com/problems/target-sum/

class Solution:
    def findTargetSumWays(self, nums: list, target: int) -> int:
        total = sum(nums)
        s = target + total
        if s < 0 or s % 2 != 0:
            return 0
        goal = s // 2
        dp = [0] * (goal + 1)
        dp[0] = 1
        for num in nums:
            for j in range(goal, num - 1, -1):
                dp[j] += dp[j - num]
        return dp[goal]
