# https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

from typing import List

class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort(key=lambda x: x[1])
        arrows = 1
        arrow_pos = points[0][1]
        for x_start, x_end in points[1:]:
            if x_start > arrow_pos:
                arrows += 1
                arrow_pos = x_end
        return arrows
