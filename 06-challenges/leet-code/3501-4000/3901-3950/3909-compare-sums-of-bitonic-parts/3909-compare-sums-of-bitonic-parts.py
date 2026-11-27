# https://leetcode.com/problems/compare-sums-of-bitonic-parts/
from typing import List


class Solution:
    def compareSums(self, nums: List[int]) -> int:
        n = len(nums)
        peak = 0
        for i in range(n - 1):
            if nums[i] > nums[i + 1]:
                peak = i
                break
            peak = i + 1
        asc_sum = sum(nums[:peak + 1])
        desc_sum = sum(nums[peak:])
        if asc_sum > desc_sum:
            return 0
        elif desc_sum > asc_sum:
            return 1
        else:
            return -1
