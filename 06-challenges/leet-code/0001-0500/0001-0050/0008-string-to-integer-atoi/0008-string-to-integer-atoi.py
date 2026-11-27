# https://leetcode.com/problems/string-to-integer-atoi/

class Solution:
    def myAtoi(self, s: str) -> int:
        MAX = 2**31 - 1
        MIN = -(2**31)
        s = s.lstrip()

        if not s:
            return 0

        sign = 1
        i = 0

        if s[0] in ('+', '-'):
            sign = -1 if s[0] == '-' else 1
            i = 1

        res = 0
        while i < len(s) and s[i].isdigit():
            res = res * 10 + int(s[i])
            if sign * res > MAX:
                return MAX
            if sign * res < MIN:
                return MIN
            i += 1

        return sign * res
