# https://leetcode.com/problems/fraction-addition-and-subtraction/
class Solution:
    def fractionAddition(self, expression: str) -> str:
        from math import gcd
        import re
        tokens = re.findall(r'[+-]?\d+/\d+', expression)
        numerator, denominator = 0, 1
        for token in tokens:
            slash = token.index('/')
            num = int(token[:slash])
            den = int(token[slash+1:])
            numerator = numerator * den + num * denominator
            denominator *= den
            g = gcd(abs(numerator), denominator)
            numerator //= g
            denominator //= g
        return f"{numerator}/{denominator}"
