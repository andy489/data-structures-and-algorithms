# https://leetcode.com/problems/longest-nice-substring/

class Solution:
    def longestNiceSubstring(self, s: str) -> str:
        if len(s) < 2:
            return ""
        for i, c in enumerate(s):
            other = c.lower() if c.isupper() else c.upper()
            if other not in s:
                left = self.longestNiceSubstring(s[:i])
                right = self.longestNiceSubstring(s[i + 1:])
                return left if len(left) >= len(right) else right
        return s
