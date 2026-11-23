# https://leetcode.com/problems/shuffle-an-array/

import random

class Solution:
    def __init__(self, nums: list[int]):
        self.original = nums[:]
        self.nums = nums

    def reset(self) -> list[int]:
        self.nums[:] = self.original
        return self.nums

    def shuffle(self) -> list[int]:
        for i in range(len(self.nums) - 1, 0, -1):
            j = random.randint(0, i)
            self.nums[i], self.nums[j] = self.nums[j], self.nums[i]
        return self.nums
