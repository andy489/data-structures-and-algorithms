# https://leetcode.com/problems/valid-digit-number/
class Solution:
    def validDigitNumber(self, n: int, x: int) -> bool:
        s = str(n)
        cx = str(x)
        return cx in s and s[0] != cx
