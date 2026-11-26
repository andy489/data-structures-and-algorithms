# https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/

class Solution:
    def checkAlmostEquivalent(self, word1: str, word2: str) -> bool:
        from collections import Counter
        diff = Counter(word1)
        for c in word2:
            diff[c] -= 1
        return all(abs(v) <= 3 for v in diff.values())
