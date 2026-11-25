# https://leetcode.com/problems/smallest-range-i/

class Solution:
    def smallestRangeI(self, nums: list, k: int) -> int:
        return max(0, max(nums) - min(nums) - 2 * k)
