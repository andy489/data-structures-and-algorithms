# https://leetcode.com/problems/minimum-area-rectangle/

class Solution:
    def minAreaRect(self, points: list) -> int:
        pts = set(map(tuple, points))
        min_area = float('inf')
        for i in range(len(points)):
            for j in range(i + 1, len(points)):
                x1, y1 = points[i]
                x2, y2 = points[j]
                if x1 != x2 and y1 != y2:
                    if (x1, y2) in pts and (x2, y1) in pts:
                        min_area = min(min_area, abs(x2 - x1) * abs(y2 - y1))
        return 0 if min_area == float('inf') else min_area
