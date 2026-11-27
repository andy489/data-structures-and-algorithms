# https://leetcode.com/problems/maximum-area-rectangle-with-point-constraints-ii/

from sortedcontainers import SortedList

class Solution:
    def maxRectangleArea(self, xCoord: list[int], yCoord: list[int]) -> int:
        # Coordinate compress y
        sorted_y = sorted(set(yCoord))
        y_rank = {y: i for i, y in enumerate(sorted_y)}
        m = len(sorted_y)

        # BIT (Fenwick tree) on compressed y
        bit = [0] * (m + 1)

        def update(i, delta=1):
            i += 1
            while i <= m:
                bit[i] += delta
                i += i & (-i)

        def query(i):
            i += 1
            s = 0
            while i > 0:
                s += bit[i]
                i -= i & (-i)
            return s

        def range_query(l, r):
            if l > r:
                return 0
            return query(r) - (query(l - 1) if l > 0 else 0)

        # Group by x, process right to left
        from collections import defaultdict
        by_x = defaultdict(list)
        for x, y in zip(xCoord, yCoord):
            by_x[x].append(y)

        pair_to_x = {}
        max_area = -1

        for x in sorted(by_x, reverse=True):
            ys = sorted(by_x[x])
            for i in range(len(ys)):
                for j in range(i + 1, len(ys)):
                    y_lo, y_hi = ys[i], ys[j]
                    key = (y_rank[y_lo], y_rank[y_hi])
                    if key in pair_to_x:
                        prev_x = pair_to_x[key]
                        cnt = range_query(y_rank[y_lo], y_rank[y_hi])
                        if cnt == 2:
                            max_area = max(max_area, (prev_x - x) * (y_hi - y_lo))
                    pair_to_x[key] = x
            for y in ys:
                update(y_rank[y])

        return max_area
