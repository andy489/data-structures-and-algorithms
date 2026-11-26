# https://leetcode.com/problems/check-if-it-is-a-good-array/

from math import gcd
class Solution:
    def isGoodArray(self, nums: list[int]) -> bool:
        from functools import reduce
        return reduce(gcd, nums) == 1
