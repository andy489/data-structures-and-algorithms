# https://leetcode.com/problems/non-decreasing-array/

class Solution:
    def checkPossibility(self, nums: list) -> bool:
        violations = 0
        for i in range(len(nums) - 1):
            if nums[i] > nums[i + 1]:
                violations += 1
                if violations > 1:
                    return False
                if i > 0 and nums[i - 1] > nums[i + 1]:
                    nums[i + 1] = nums[i]
                else:
                    nums[i] = nums[i + 1]
        return True
