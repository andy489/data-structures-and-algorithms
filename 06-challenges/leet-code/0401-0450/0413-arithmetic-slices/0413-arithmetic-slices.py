# https://leetcode.com/problems/arithmetic-slices/

class Solution:
    def numberOfArithmeticSlices(self, nums: list[int]) -> int:
        curr = total = 0
        for i in range(2, len(nums)):
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]:
                curr += 1
                total += curr
            else:
                curr = 0
        return total
