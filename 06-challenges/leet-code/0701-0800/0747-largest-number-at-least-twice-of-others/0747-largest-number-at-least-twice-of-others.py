# https://leetcode.com/problems/largest-number-at-least-twice-of-others/

class Solution:
    def dominantIndex(self, nums: list[int]) -> int:
        max_idx = nums.index(max(nums))
        for i, n in enumerate(nums):
            if i != max_idx and nums[max_idx] < 2 * n:
                return -1
        return max_idx
