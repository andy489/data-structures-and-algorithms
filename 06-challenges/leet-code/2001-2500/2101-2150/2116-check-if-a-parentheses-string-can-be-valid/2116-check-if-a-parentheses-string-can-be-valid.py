# https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/
class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        n = len(s)
        if n % 2 != 0:
            return False
        lo, hi = 0, 0
        for i in range(n):
            if locked[i] == '0':
                lo -= 1
                hi += 1
            elif s[i] == '(':
                lo += 1
                hi += 1
            else:
                lo -= 1
                hi -= 1
            if hi < 0:
                return False
            lo = max(lo, 0)
        return lo == 0
