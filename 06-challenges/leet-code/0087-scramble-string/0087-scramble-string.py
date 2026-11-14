# https://leetcode.com/problems/scramble-string/

from functools import lru_cache

class Solution:
    def isScramble(self, s1: str, s2: str) -> bool:
        @lru_cache(maxsize=None)
        def helper(a, b):
            if a == b:
                return True
            if sorted(a) != sorted(b):
                return False
            n = len(a)
            for k in range(1, n):
                if (helper(a[:k], b[:k]) and helper(a[k:], b[k:])) or \
                   (helper(a[:k], b[n-k:]) and helper(a[k:], b[:n-k])):
                    return True
            return False
        return helper(s1, s2)
