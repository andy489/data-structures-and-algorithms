# https://leetcode.com/problems/find-indices-with-index-and-value-difference-ii/

class Solution:
    def findIndices(self, nums: list[int], indexDifference: int, valueDifference: int) -> list[int]:
        min_idx = max_idx = 0
        for j in range(indexDifference, len(nums)):
            i = j - indexDifference
            if nums[i] < nums[min_idx]:
                min_idx = i
            if nums[i] > nums[max_idx]:
                max_idx = i
            if nums[j] - nums[min_idx] >= valueDifference:
                return [min_idx, j]
            if nums[max_idx] - nums[j] >= valueDifference:
                return [max_idx, j]
        return [-1, -1]
