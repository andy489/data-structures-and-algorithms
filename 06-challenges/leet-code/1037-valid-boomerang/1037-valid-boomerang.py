# https://leetcode.com/problems/valid-boomerang/

class Solution:
    def isBoomerang(self, points: list[list[int]]) -> bool:
        (x0,y0),(x1,y1),(x2,y2) = points
        return (x1-x0)*(y2-y0) - (y1-y0)*(x2-x0) != 0
