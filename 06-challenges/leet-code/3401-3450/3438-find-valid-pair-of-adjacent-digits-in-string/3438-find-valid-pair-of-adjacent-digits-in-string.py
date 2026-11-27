# https://leetcode.com/problems/find-valid-pair-of-adjacent-digits-in-string/
class Solution:
    def findValidPair(self, s: str) -> str:
        freq = {}
        for c in s:
            freq[c] = freq.get(c, 0) + 1
        for i in range(len(s) - 1):
            a, b = s[i], s[i + 1]
            if a != b and freq[a] == int(a) and freq[b] == int(b):
                return a + b
        return ""
