# https://leetcode.com/problems/maximum-number-of-visible-points/

import math
import bisect

class Solution:
    def visiblePoints(self, points: list[list[int]], angle: int, location: list[int]) -> int:
        lx, ly = location
        angles = []
        at_origin = 0
        for x, y in points:
            dx, dy = x - lx, y - ly
            if dx == 0 and dy == 0:
                at_origin += 1
            else:
                angles.append(math.degrees(math.atan2(dy, dx)))
        angles.sort()
        doubled = angles + [a + 360 for a in angles]
        max_visible = 0
        left = 0
        for right in range(len(doubled)):
            while doubled[right] - doubled[left] > angle:
                left += 1
            max_visible = max(max_visible, right - left + 1)
        return max_visible + at_origin
