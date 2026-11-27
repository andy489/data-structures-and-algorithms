# https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/

class Solution:
    def minimumPushes(self, word: str) -> int:
        from collections import Counter
        freqs = sorted(Counter(word).values(), reverse=True)
        return sum(f * (i // 8 + 1) for i, f in enumerate(freqs))
