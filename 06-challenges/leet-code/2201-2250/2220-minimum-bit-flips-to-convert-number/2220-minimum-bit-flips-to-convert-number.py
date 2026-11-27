# https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
class Solution:
    def minBitFlips(self, start: int, goal: int) -> int:
        return bin(start ^ goal).count('1')
