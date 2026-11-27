# https://leetcode.com/problems/maximum-xor-for-each-query/

from functools import reduce
from operator import xor

class Solution:
    def getMaximumXor(self, nums: list[int], maximumBit: int) -> list[int]:
        mask = (1 << maximumBit) - 1
        xor_all = reduce(xor, nums)
        ans = []
        for x in reversed(nums):
            ans.append(xor_all ^ mask)
            xor_all ^= x
        return ans
