# https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/

class Solution:
    def minFlips(self, a: int, b: int, c: int) -> int:
        flips = 0
        while a or b or c:
            ba, bb, bc = a & 1, b & 1, c & 1
            if bc:
                flips += (ba == 0 and bb == 0)
            else:
                flips += ba + bb
            a >>= 1; b >>= 1; c >>= 1
        return flips
