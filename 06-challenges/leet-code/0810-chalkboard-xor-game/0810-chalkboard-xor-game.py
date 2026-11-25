# https://leetcode.com/problems/chalkboard-xor-game/

from functools import reduce
from operator import xor

class Solution:
    def xorGame(self, nums: list[int]) -> bool:
        return reduce(xor, nums) == 0 or len(nums) % 2 == 0
