# https://leetcode.com/problems/construct-k-palindrome-strings/

from collections import Counter

class Solution:
    def canConstruct(self, s: str, k: int) -> bool:
        if k > len(s):
            return False
        odds = sum(1 for v in Counter(s).values() if v % 2)
        return odds <= k
