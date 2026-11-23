# https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/

import random
import bisect

class Solution:
    def __init__(self, rects: list):
        self.rects = rects
        self.prefix_sums = []
        cumulative = 0
        for r in rects:
            cumulative += (r[2] - r[0] + 1) * (r[3] - r[1] + 1)
            self.prefix_sums.append(cumulative)
        self.total = cumulative

    def pick(self) -> list:
        target = random.randint(0, self.total - 1)
        idx = bisect.bisect_right(self.prefix_sums, target)
        rect = self.rects[idx]
        offset = target - (self.prefix_sums[idx - 1] if idx > 0 else 0)
        width = rect[2] - rect[0] + 1
        return [rect[0] + offset % width, rect[1] + offset // width]
