# https://leetcode.com/problems/fraction-to-recurring-decimal/

# Long division with dict — O(d) time, O(d) space
class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        if numerator == 0:
            return "0"
        sign = '-' if (numerator < 0) ^ (denominator < 0) else ''
        num, den = abs(numerator), abs(denominator)
        integer_part = num // den
        rem = num % den
        if rem == 0:
            return sign + str(integer_part)
        frac = []
        remainder_index: dict[int, int] = {}
        while rem != 0:
            if rem in remainder_index:
                i = remainder_index[rem]
                frac.insert(i, '(')
                frac.append(')')
                break
            remainder_index[rem] = len(frac)
            rem *= 10
            frac.append(str(rem // den))
            rem %= den
        return sign + str(integer_part) + '.' + ''.join(frac)
