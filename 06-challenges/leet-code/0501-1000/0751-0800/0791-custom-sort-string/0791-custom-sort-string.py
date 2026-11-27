# https://leetcode.com/problems/custom-sort-string/

from collections import Counter

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        freq = Counter(s)
        result = []
        for c in order:
            result.append(c * freq.pop(c, 0))
        for c, cnt in freq.items():
            result.append(c * cnt)
        return ''.join(result)
