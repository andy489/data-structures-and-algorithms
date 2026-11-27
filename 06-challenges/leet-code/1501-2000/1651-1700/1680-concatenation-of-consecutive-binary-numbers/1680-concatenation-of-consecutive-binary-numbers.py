# https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/

class Solution:
    def concatenatedBinary(self, n: int) -> int:
        MOD = 10 ** 9 + 7
        result = 0
        length = 0
        for i in range(1, n + 1):
            if i & (i - 1) == 0:
                length += 1
            result = ((result << length) | i) % MOD
        return result
