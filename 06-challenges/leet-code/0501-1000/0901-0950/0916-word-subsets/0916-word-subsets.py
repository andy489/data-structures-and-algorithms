# https://leetcode.com/problems/word-subsets/

from collections import Counter

class Solution:
    def wordSubsets(self, words1: list, words2: list) -> list:
        need = Counter()
        for b in words2:
            for c, cnt in Counter(b).items():
                need[c] = max(need[c], cnt)
        return [a for a in words1 if not (need - Counter(a))]
