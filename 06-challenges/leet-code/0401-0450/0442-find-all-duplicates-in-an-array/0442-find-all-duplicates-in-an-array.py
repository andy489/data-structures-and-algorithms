# https://leetcode.com/problems/find-all-duplicates-in-an-array/

class Solution:
    def findDuplicates(self, nums: list[int]) -> list[int]:
        duplicates = []
        for num in nums:
            idx = abs(num) - 1
            if nums[idx] < 0:
                duplicates.append(idx + 1)
            else:
                nums[idx] = -nums[idx]
        return duplicates
