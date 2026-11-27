# https://leetcode.com/problems/limit-occurrences-in-sorted-array/
class Solution:
    def limitOccurrences(self, nums: list[int], k: int) -> list[int]:
        result = []
        count = 0
        for i, v in enumerate(nums):
            if i == 0 or v != nums[i - 1]:
                count = 1
            else:
                count += 1
            if count <= k:
                result.append(v)
        return result
