# https://leetcode.com/problems/maximize-the-total-height-of-unique-towers/

from typing import List


class Solution:
    def maximumTotalSum(self, maximumHeight: List[int]) -> int:
        maximumHeight.sort()
        n = len(maximumHeight)
        result = maximumHeight[-1]
        prev = maximumHeight[-1]
        for i in range(n - 2, -1, -1):
            h = min(maximumHeight[i], prev - 1)
            if h < 1:
                return -1
            result += h
            prev = h
        return result
