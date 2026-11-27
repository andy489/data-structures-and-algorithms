# https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/

from bisect import bisect_right

class Solution:
    def numSmallerByFrequency(self, queries: list[str], words: list[str]) -> list[int]:
        def f(s: str) -> int:
            m = min(s)
            return s.count(m)

        word_fs = sorted(f(w) for w in words)
        return [len(word_fs) - bisect_right(word_fs, f(q)) for q in queries]
