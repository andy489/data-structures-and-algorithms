# https://leetcode.com/problems/number-of-even-and-odd-bits/
class Solution:
    def evenOddBit(self, n: int) -> list[int]:
        even = odd = 0
        i = 0
        while n:
            if n & 1:
                if i % 2 == 0:
                    even += 1
                else:
                    odd += 1
            n >>= 1
            i += 1
        return [even, odd]
