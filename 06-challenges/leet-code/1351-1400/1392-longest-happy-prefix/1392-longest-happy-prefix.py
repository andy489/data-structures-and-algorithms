# https://leetcode.com/problems/longest-happy-prefix/

class Solution:
    def longestPrefix(self, s: str) -> str:
        n = len(s)
        kmp = [0] * n
        j = 0
        for i in range(1, n):
            while j > 0 and s[i] != s[j]:
                j = kmp[j-1]
            if s[i] == s[j]:
                j += 1
            kmp[i] = j
        return s[:kmp[-1]]
