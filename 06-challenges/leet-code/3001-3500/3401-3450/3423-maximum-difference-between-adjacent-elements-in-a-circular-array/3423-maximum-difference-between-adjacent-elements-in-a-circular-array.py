# https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/

class Solution:
    def maxAdjacentDistance(self, nums: list[int]) -> int:
        n = len(nums)
        max_diff = abs(nums[0] - nums[-1])
        for i in range(1, n):
            max_diff = max(max_diff, abs(nums[i] - nums[i - 1]))
        return max_diff
