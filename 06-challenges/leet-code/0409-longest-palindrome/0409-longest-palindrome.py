# https://leetcode.com/problems/longest-palindrome/

from collections import Counter

class Solution:
    def longestPalindrome(self, s: str) -> int:
        length = sum(c // 2 * 2 for c in Counter(s).values())
        return length + (1 if length < len(s) else 0)
