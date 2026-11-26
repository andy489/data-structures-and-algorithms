# https://leetcode.com/problems/perfect-rectangle/

class Solution:
    def isRectangleCover(self, rectangles: list[list[int]]) -> bool:
        corners: set[tuple[int, int]] = set()
        x1 = y1 = float('inf')
        x2 = y2 = float('-inf')
        area = 0
        for rx1, ry1, rx2, ry2 in rectangles:
            x1 = min(x1, rx1); y1 = min(y1, ry1)
            x2 = max(x2, rx2); y2 = max(y2, ry2)
            area += (rx2 - rx1) * (ry2 - ry1)
            for pt in [(rx1, ry1), (rx1, ry2), (rx2, ry1), (rx2, ry2)]:
                if pt in corners:
                    corners.discard(pt)
                else:
                    corners.add(pt)
        if corners != {(x1, y1), (x1, y2), (x2, y1), (x2, y2)}:
            return False
        return area == (x2 - x1) * (y2 - y1)
