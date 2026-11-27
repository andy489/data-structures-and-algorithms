# https://leetcode.com/problems/count-number-of-rectangles-containing-each-point/

import bisect

class Solution:
    def countRectangles(self, rectangles: list[list[int]], points: list[list[int]]) -> list[int]:
        by_height = [[] for _ in range(101)]
        for l, h in rectangles:
            by_height[h].append(l)
        for h in range(1, 101):
            by_height[h].sort()

        ans = []
        for x, y in points:
            cnt = 0
            for h in range(y, 101):
                lengths = by_height[h]
                idx = bisect.bisect_left(lengths, x)
                cnt += len(lengths) - idx
            ans.append(cnt)
        return ans
