# https://leetcode.com/problems/first-matching-character-from-both-ends/

class Solution:
    def firstMatchingIndex(self, s: str) -> int:
        n = len(s)
        for i in range(n):
            if s[i] == s[n - 1 - i]:
                return i
        return -1
