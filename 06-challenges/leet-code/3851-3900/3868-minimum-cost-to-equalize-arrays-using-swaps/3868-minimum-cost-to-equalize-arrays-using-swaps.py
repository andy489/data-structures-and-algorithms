# https://leetcode.com/problems/minimum-cost-to-equalize-arrays-using-swaps/

from collections import Counter
from typing import List

class Solution:
    def minCost(self, nums1: List[int], nums2: List[int]) -> int:
        combined = Counter(nums1) + Counter(nums2)
        for cnt in combined.values():
            if cnt % 2 != 0:
                return -1
        a = sorted(nums1)
        b = sorted(nums2)
        diff = sum(1 for x, y in zip(a, b) if x != y)
        return diff // 2
