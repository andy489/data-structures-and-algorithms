# https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/

class Solution:
    def countGoodRectangles(self, rectangles: list[list[int]]) -> int:
        max_len = count = 0
        for l, w in rectangles:
            side = min(l, w)
            if side > max_len:
                max_len, count = side, 1
            elif side == max_len:
                count += 1
        return count
