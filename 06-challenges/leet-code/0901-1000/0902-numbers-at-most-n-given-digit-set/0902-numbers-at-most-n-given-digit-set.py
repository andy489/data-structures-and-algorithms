# https://leetcode.com/problems/numbers-at-most-n-given-digit-set/

class Solution:
    def atMostNGivenDigitSet(self, digits: list, n: int) -> int:
        s = str(n)
        L, d = len(s), len(digits)
        result = sum(d ** length for length in range(1, L))
        for i, ch in enumerate(s):
            result += sum(1 for dig in digits if dig < ch) * (d ** (L - 1 - i))
            if ch not in digits:
                return result
        return result + 1
