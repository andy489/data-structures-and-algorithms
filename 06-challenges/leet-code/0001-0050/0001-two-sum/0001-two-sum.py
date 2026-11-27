# https://leetcode.com/problems/two-sum/

class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        indices = {}

        for i, num in enumerate(nums):
            complement = target - num
            if complement in indices:
                return [indices[complement], i]
            indices[num] = i

        return [-1, -1]
