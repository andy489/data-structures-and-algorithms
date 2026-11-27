# https://leetcode.com/problems/smallest-pair-with-different-frequencies/

from collections import Counter
from typing import List

class Solution:
    def smallestPair(self, nums: List[int]) -> List[int]:
        freq = Counter(nums)
        vals = sorted(freq.keys())
        for i in range(len(vals)):
            for j in range(i + 1, len(vals)):
                if freq[vals[i]] != freq[vals[j]]:
                    return [vals[i], vals[j]]
        return [-1, -1]
