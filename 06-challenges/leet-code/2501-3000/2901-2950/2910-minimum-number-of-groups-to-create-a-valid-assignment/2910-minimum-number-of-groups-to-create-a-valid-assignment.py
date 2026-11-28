# https://leetcode.com/problems/minimum-number-of-groups-to-create-a-valid-assignment/

from collections import Counter
import math

class Solution:
    def minGroupsForValidAssignment(self, nums: list[int]) -> int:
        freq = Counter(nums)
        min_freq = min(freq.values())

        for k in range(min_freq, 0, -1):
            boxes = 0
            valid = True
            for f in freq.values():
                if f < k:
                    valid = False
                    break
                boxes += math.ceil(f / (k + 1))
            if valid:
                return boxes
        return len(nums)
