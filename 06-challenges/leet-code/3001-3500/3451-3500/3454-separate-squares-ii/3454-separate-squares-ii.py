# https://leetcode.com/problems/separate-squares-ii/

from sortedcontainers import SortedList

class Solution:
    def separateSquares(self, squares: list[list[int]]) -> float:
        def union_below(y: float) -> float:
            # Compute union area of all squares clipped to below y
            xs = sorted(set(x for x, yb, l in squares for x in [x, x + l]))
            total = 0.0
            for i in range(len(xs) - 1):
                x1, x2 = xs[i], xs[i + 1]
                width = x2 - x1
                max_h = 0.0
                for xb, yb, l in squares:
                    if xb <= x1 and xb + l >= x2:
                        bottom, top = yb, yb + l
                        if bottom < y:
                            clipped_top = min(top, y)
                            max_h = max(max_h, clipped_top - bottom)
                total += width * max_h
            return total

        lo = min(y for x, y, l in squares)
        hi = max(y + l for x, y, l in squares)
        total_area = union_below(hi)

        for _ in range(100):
            mid = (lo + hi) / 2.0
            below = union_below(mid)
            above = total_area - below
            if below < above:
                lo = mid
            else:
                hi = mid
        return lo
