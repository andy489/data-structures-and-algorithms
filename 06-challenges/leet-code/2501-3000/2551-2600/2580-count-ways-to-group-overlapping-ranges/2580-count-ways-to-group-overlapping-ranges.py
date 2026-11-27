# https://leetcode.com/problems/count-ways-to-group-overlapping-ranges/

from typing import List

class Solution:
    def countWays(self, ranges: List[List[int]]) -> int:
        MOD = 10**9 + 7
        ranges.sort()
        components = 0
        max_end = -1
        for start, end in ranges:
            if start > max_end:
                components += 1
            max_end = max(max_end, end)
        return pow(2, components, MOD)
