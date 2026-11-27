# https://leetcode.com/problems/shortest-completing-word/

from collections import Counter

class Solution:
    def shortestCompletingWord(self, licensePlate: str, words: list[str]) -> str:
        need = Counter(c.lower() for c in licensePlate if c.isalpha())
        result = None
        for word in words:
            have = Counter(word)
            if all(have[c] >= cnt for c, cnt in need.items()):
                if result is None or len(word) < len(result):
                    result = word
        return result
