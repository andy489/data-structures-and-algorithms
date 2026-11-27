# https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/

class Solution:
    def minimumOneBitOperations(self, n: int) -> int:
        result = 0
        while n:
            result ^= n
            n >>= 1
        return result
