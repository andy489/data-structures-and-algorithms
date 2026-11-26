# https://leetcode.com/problems/circle-and-rectangle-overlapping/

class Solution:
    def checkOverlap(self, radius: int, xCenter: int, yCenter: int, x1: int, y1: int, x2: int, y2: int) -> bool:
        cx = max(x1, min(xCenter, x2))
        cy = max(y1, min(yCenter, y2))
        return (xCenter - cx) ** 2 + (yCenter - cy) ** 2 <= radius ** 2
