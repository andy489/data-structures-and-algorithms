# https://leetcode.com/problems/first-missing-positive/

class Solution:
    def firstMissingPositive(self, nums: list[int]) -> int:
        n = len(nums)
        for i in range(n):
            while 1 <= nums[i] <= n and nums[nums[i] - 1] != nums[i]:
                correct = nums[i] - 1
                nums[i], nums[correct] = nums[correct], nums[i]
        for i in range(n):
            if nums[i] != i + 1:
                return i + 1
        return n + 1
