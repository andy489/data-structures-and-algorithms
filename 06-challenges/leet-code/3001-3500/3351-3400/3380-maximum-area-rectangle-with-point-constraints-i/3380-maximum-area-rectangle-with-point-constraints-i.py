# https://leetcode.com/problems/maximum-area-rectangle-with-point-constraints-i/

class Solution:
    def maxRectangleArea(self, points: list[list[int]]) -> int:
        pt_set = {(x, y) for x, y in points}
        max_area = -1

        for i in range(len(points)):
            for j in range(i + 1, len(points)):
                x1 = min(points[i][0], points[j][0])
                x2 = max(points[i][0], points[j][0])
                y1 = min(points[i][1], points[j][1])
                y2 = max(points[i][1], points[j][1])
                if x1 == x2 or y1 == y2:
                    continue
                # Check all 4 corners exist
                if not all((cx, cy) in pt_set for cx in (x1, x2) for cy in (y1, y2)):
                    continue
                # Check no non-corner point inside or on border
                corners = {(x1, y1), (x1, y2), (x2, y1), (x2, y2)}
                valid = all(
                    not (x1 <= px <= x2 and y1 <= py <= y2) or (px, py) in corners
                    for px, py in points
                )
                if valid:
                    max_area = max(max_area, (x2 - x1) * (y2 - y1))

        return max_area
