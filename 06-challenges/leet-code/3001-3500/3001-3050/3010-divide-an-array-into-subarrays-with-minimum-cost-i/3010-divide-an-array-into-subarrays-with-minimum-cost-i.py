# https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/

class Solution:
    def minimumCost(self, nums: list[int]) -> int:
        rest = sorted(nums[1:])
        return nums[0] + rest[0] + rest[1]
