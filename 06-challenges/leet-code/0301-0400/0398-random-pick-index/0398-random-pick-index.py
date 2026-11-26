# https://leetcode.com/problems/random-pick-index/

import random

class Solution:
    def __init__(self, nums: list[int]):
        self.nums = nums

    def pick(self, target: int) -> int:
        result = -1
        count = 0
        for i, v in enumerate(self.nums):
            if v == target:
                count += 1
                if random.randint(1, count) == 1:
                    result = i
        return result
