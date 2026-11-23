# https://leetcode.com/problems/sum-of-two-integers/

class Solution:
    def getSum(self, a: int, b: int) -> int:
        MASK = 0xFFFFFFFF
        MAX = 0x7FFFFFFF
        while b & MASK:
            carry = ((a & b) << 1) & MASK
            a = (a ^ b) & MASK
            b = carry
        return a if a <= MAX else ~(a ^ MASK)
