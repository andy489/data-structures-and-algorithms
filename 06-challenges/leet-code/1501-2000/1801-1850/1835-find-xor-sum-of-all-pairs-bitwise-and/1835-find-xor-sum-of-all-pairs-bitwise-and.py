# https://leetcode.com/problems/find-xor-sum-of-all-pairs-bitwise-and/

from functools import reduce
from operator import xor

class Solution:
    def getXORSum(self, arr1: list[int], arr2: list[int]) -> int:
        return reduce(xor, arr1) & reduce(xor, arr2)
