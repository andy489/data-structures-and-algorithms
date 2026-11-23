# https://leetcode.com/problems/sort-characters-by-frequency/

from collections import Counter

class Solution:
    def frequencySort(self, s: str) -> str:
        freq = Counter(s)
        buckets = [[] for _ in range(len(s) + 1)]
        for ch, cnt in freq.items():
            buckets[cnt].append(ch)
        result = []
        for f in range(len(s), 0, -1):
            for ch in buckets[f]:
                result.append(ch * f)
        return ''.join(result)
