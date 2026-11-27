# https://leetcode.com/problems/house-robber/

# Solution 1: DP — O(n) time, O(1) space
class Solution:
    def rob(self, nums: list[int]) -> int:
        prev2 = prev1 = 0
        for num in nums:
            curr = max(prev1, prev2 + num)
            prev2, prev1 = prev1, curr
        return prev1


# Solution 2: DP array — O(n) time, O(n) space
class Solution2:
    def rob(self, nums: list[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, n):
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        return dp[n - 1]
