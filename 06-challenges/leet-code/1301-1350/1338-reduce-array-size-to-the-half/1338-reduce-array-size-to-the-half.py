# https://leetcode.com/problems/reduce-array-size-to-the-half/

from collections import Counter

class Solution:
    def minSetSize(self, arr: list[int]) -> int:
        counts = sorted(Counter(arr).values(), reverse=True)
        half, removed, size = len(arr)//2, 0, 0
        for c in counts:
            removed += c
            size += 1
            if removed >= half:
                return size
        return size
