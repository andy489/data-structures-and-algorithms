# https://leetcode.com/problems/number-of-segments-in-a-string/

class Solution:
    def countSegments(self, s: str) -> int:
        return sum(1 for i in range(len(s)) if s[i] != ' ' and (i == 0 or s[i - 1] == ' '))
