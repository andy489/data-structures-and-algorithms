# https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

from typing import List

class Solution:
    def minMoves2(self, nums: List[int]) -> int:
        nums.sort()
        median = nums[len(nums) // 2]
        return sum(abs(n - median) for n in nums)
