# https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/

from collections import Counter

class Solution:
    def minDeletions(self, s: str) -> int:
        freqs = sorted(Counter(s).values(), reverse=True)
        seen = set()
        deletions = 0
        for f in freqs:
            while f > 0 and f in seen:
                f -= 1
                deletions += 1
            seen.add(f)
        return deletions
