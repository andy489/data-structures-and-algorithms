# https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/

class Solution:
    def getNoZeroIntegers(self, n: int) -> list[int]:
        def has_zero(x):
            return '0' in str(x)
        for a in range(1, n):
            if not has_zero(a) and not has_zero(n-a):
                return [a, n-a]
        return []
