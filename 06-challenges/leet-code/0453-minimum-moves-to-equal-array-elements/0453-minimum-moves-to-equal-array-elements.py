# https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

from typing import List

class Solution:
    def minMoves(self, nums: List[int]) -> int:
        min_val = min(nums)
        return sum(nums) - min_val * len(nums)
