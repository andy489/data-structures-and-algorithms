# https://leetcode.com/problems/equal-rational-numbers/

from fractions import Fraction

class Solution:
    def isRationalEqual(self, s: str, t: str) -> bool:
        def toFrac(x):
            if '.' not in x:
                return Fraction(int(x))
            dot = x.index('.')
            lp = x.find('(')
            int_part = int(x[:dot])
            if lp == -1:
                non_rep = x[dot+1:]
                scale = 10 ** len(non_rep)
                return Fraction(int_part * scale + (int(non_rep) if non_rep else 0), scale)
            non_rep = x[dot+1:lp]
            rep = x[lp+1:-1]
            scale = 10 ** len(non_rep)
            rep_den = 10 ** len(rep) - 1
            return Fraction(int_part) + Fraction(int(non_rep) if non_rep else 0, scale) + Fraction(int(rep), scale * rep_den)
        return toFrac(s) == toFrac(t)
