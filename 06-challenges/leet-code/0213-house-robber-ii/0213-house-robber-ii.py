# https://leetcode.com/problems/house-robber-ii/

class Solution:
    def rob(self, nums: list[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]

        def rob_linear(lo: int, hi: int) -> int:
            prev2 = prev1 = 0
            for i in range(lo, hi + 1):
                prev2, prev1 = prev1, max(prev1, prev2 + nums[i])
            return prev1

        return max(rob_linear(0, n - 2), rob_linear(1, n - 1))
