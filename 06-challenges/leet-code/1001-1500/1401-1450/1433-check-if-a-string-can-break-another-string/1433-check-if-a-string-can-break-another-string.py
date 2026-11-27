# https://leetcode.com/problems/check-if-a-string-can-break-another-string/

class Solution:
    def checkIfCanBreak(self, s1: str, s2: str) -> bool:
        a, b = sorted(s1), sorted(s2)
        return all(x >= y for x, y in zip(a, b)) or all(y >= x for x, y in zip(a, b))
