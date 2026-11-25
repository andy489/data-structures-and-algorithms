# https://leetcode.com/problems/uncommon-words-from-two-sentences/

from collections import Counter

class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> list[str]:
        count = Counter((s1 + " " + s2).split())
        return [w for w, c in count.items() if c == 1]
