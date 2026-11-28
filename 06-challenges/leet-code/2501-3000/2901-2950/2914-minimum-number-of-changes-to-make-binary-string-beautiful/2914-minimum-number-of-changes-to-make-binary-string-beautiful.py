# https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/

class Solution:
    def minChanges(self, s: str) -> int:
        return sum(s[i] != s[i + 1] for i in range(0, len(s), 2))
