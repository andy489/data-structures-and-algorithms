# https://leetcode.com/problems/smallest-stable-index-i/
from typing import List


class Solution:
    def smallestStableIndex(self, nums: List[int], k: int) -> int:
        n = len(nums)
        suffix_min = [0] * n
        suffix_min[n - 1] = nums[n - 1]
        for i in range(n - 2, -1, -1):
            suffix_min[i] = min(suffix_min[i + 1], nums[i])
        prefix_max = nums[0]
        for i in range(n):
            if i > 0:
                prefix_max = max(prefix_max, nums[i])
            if prefix_max - suffix_min[i] <= k:
                return i
        return -1
