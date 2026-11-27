# https://leetcode.com/problems/check-if-an-original-string-exists-given-two-encoded-strings/

class Solution:
    def possiblyEquals(self, s1: str, s2: str) -> bool:
        from functools import lru_cache
        import re
        def tokenize(s):
            tokens = []
            i = 0
            while i < len(s):
                if s[i].isdigit():
                    j = i
                    while j < len(s) and s[j].isdigit():
                        j += 1
                    tokens.append(int(s[i:j]))
                    i = j
                else:
                    tokens.append(s[i])
                    i += 1
            return tokens
        t1 = tokenize(s1)
        t2 = tokenize(s2)
        @lru_cache(maxsize=None)
        def dp(i, j, diff):
            if i == len(t1) and j == len(t2):
                return diff == 0
            if i < len(t1) and isinstance(t1[i], int):
                return dp(i + 1, j, diff + t1[i])
            if j < len(t2) and isinstance(t2[j], int):
                return dp(i, j + 1, diff - t2[j])
            if diff > 0 and i < len(t1):
                return dp(i + 1, j, diff - 1)
            if diff < 0 and j < len(t2):
                return dp(i, j + 1, diff + 1)
            if diff == 0 and i < len(t1) and j < len(t2) and t1[i] == t2[j]:
                return dp(i + 1, j + 1, 0)
            return False
        return dp(0, 0, 0)
