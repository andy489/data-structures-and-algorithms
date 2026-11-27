# https://leetcode.com/problems/numbers-with-repeated-digits/

class Solution:
    def numDupDigitsAtMostN(self, n: int) -> int:
        from math import perm
        digits = list(map(int, str(n + 1)))
        length = len(digits)
        result = 0
        # Shorter lengths
        p = 9
        for i in range(1, length):
            result += p
            p *= (10 - i)
        # Same length
        used = set()
        for i, d in enumerate(digits):
            start = 1 if i == 0 else 0
            for x in range(start, d):
                if x not in used:
                    result += perm(10 - i - 1, length - i - 1)
            if d in used:
                break
            used.add(d)
            if i == length - 1:
                result += 1
        return n - result
