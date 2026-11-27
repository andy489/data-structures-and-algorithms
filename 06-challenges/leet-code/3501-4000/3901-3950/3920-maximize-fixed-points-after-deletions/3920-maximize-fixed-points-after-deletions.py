# https://leetcode.com/problems/maximize-fixed-points-after-deletions/
from typing import List


class Solution:
    def maximizeFixedPoints(self, nums: List[int]) -> int:
        best = {}
        ans = 0
        for v in nums:
            prev = best.get(v - 1, 0)
            new_best = prev + 1
            if new_best > best.get(v, 0):
                best[v] = new_best
            ans = max(ans, best[v])
        return ans
