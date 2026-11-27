# https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
from collections import Counter

class Solution:
    def longestPalindrome(self, words: list) -> int:
        freq = Counter(words)
        length = 0
        center_used = False
        for w, cnt in freq.items():
            rev = w[::-1]
            if w == rev:
                length += (cnt // 2) * 4
                if cnt % 2 == 1 and not center_used:
                    length += 2
                    center_used = True
            elif w < rev:
                pairs = min(cnt, freq.get(rev, 0))
                length += pairs * 4
        return length
