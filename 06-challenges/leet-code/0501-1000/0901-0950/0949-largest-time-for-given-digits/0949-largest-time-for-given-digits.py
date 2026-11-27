# https://leetcode.com/problems/largest-time-for-given-digits/

from itertools import permutations

class Solution:
    def largestTimeFromDigits(self, arr: list) -> str:
        best = -1
        for a, b, c, d in permutations(arr):
            h, m = a * 10 + b, c * 10 + d
            if h < 24 and m < 60:
                best = max(best, h * 60 + m)
        return '' if best == -1 else f'{best//60:02d}:{best%60:02d}'
