# https://leetcode.com/problems/reverse-bits/

# Bit manipulation — O(1) time, O(1) space
class Solution:
    def reverseBits(self, n: int) -> int:
        result = 0
        for _ in range(32):
            result = (result << 1) | (n & 1)
            n >>= 1
        return result
