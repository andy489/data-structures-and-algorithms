# https://leetcode.com/problems/maximum-possible-number-by-binary-concatenation/

from itertools import permutations
from typing import List


class Solution:
    def maxGoodNumber(self, nums: List[int]) -> int:
        best = 0
        for perm in permutations(nums):
            val = 0
            for x in perm:
                bits = x.bit_length()
                val = (val << bits) | x
            best = max(best, val)
        return best
