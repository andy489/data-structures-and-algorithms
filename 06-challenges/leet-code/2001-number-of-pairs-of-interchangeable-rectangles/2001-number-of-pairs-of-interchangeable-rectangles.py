# https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/

class Solution:
    def interchangeableRectangles(self, rectangles: list[list[int]]) -> int:
        from math import gcd
        freq = {}
        for w, h in rectangles:
            g = gcd(w, h)
            key = (w // g, h // g)
            freq[key] = freq.get(key, 0) + 1
        return sum(c * (c - 1) // 2 for c in freq.values())
