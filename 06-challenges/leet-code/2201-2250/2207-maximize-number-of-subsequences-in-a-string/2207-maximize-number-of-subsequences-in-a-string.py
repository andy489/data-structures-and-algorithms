# https://leetcode.com/problems/maximize-number-of-subsequences-in-a-string/
class Solution:
    def maximumSubsequenceCount(self, text: str, pattern: str) -> int:
        p0, p1 = pattern[0], pattern[1]
        base = 0
        count_p0 = 0
        count_p1 = 0
        for c in text:
            if c == p1:
                base += count_p0
                count_p1 += 1
            if c == p0:
                count_p0 += 1
        return base + max(count_p0, count_p1)
