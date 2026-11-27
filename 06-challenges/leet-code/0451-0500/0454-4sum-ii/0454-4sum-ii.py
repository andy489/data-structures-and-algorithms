# https://leetcode.com/problems/4sum-ii/

from typing import List
from collections import defaultdict

class Solution:
    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        pair_sums = defaultdict(int)
        for a in nums1:
            for b in nums2:
                pair_sums[a + b] += 1
        count = 0
        for c in nums3:
            for d in nums4:
                count += pair_sums[-(c + d)]
        return count
