# https://leetcode.com/problems/separate-squares-i/

class Solution:
    def separateSquares(self, squares: list[list[int]]) -> float:
        lo = float('inf')
        hi = 0.0
        for x, y, l in squares:
            lo = min(lo, y)
            hi = max(hi, y + l)

        for _ in range(100):
            mid = (lo + hi) / 2.0
            below = above = 0.0
            for x, y, l in squares:
                top = y + l
                if mid >= top:
                    below += l * l
                elif mid <= y:
                    above += l * l
                else:
                    below += (mid - y) * l
                    above += (top - mid) * l
            if below < above:
                lo = mid
            else:
                hi = mid
        return lo
