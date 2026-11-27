# https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/

class Solution:
    def minOperations(self, nums: list[int]) -> int:
        ops = 0
        for i in range(1, len(nums)):
            if nums[i] <= nums[i - 1]:
                ops += nums[i - 1] - nums[i] + 1
                nums[i] = nums[i - 1] + 1
        return ops
