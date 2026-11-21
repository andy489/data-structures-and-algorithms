# https://leetcode.com/problems/maximum-gap/

import math

# Bucket sort (pigeonhole) — O(n) time, O(n) space
class Solution:
    def maximumGap(self, nums: list[int]) -> int:
        n = len(nums)
        if n < 2:
            return 0
        lo, hi = min(nums), max(nums)
        if lo == hi:
            return 0
        w = max(1, math.ceil((hi - lo) / (n - 1)))
        buckets = (hi - lo) // w + 1
        b_min = [float('inf')] * buckets
        b_max = [float('-inf')] * buckets
        for x in nums:
            i = (x - lo) // w
            b_min[i] = min(b_min[i], x)
            b_max[i] = max(b_max[i], x)
        gap, prev_max = 0, b_max[0]
        for i in range(1, buckets):
            if b_min[i] == float('inf'):
                continue
            gap = max(gap, b_min[i] - prev_max)
            prev_max = b_max[i]
        return gap
