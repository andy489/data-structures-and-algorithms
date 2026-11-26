# https://leetcode.com/problems/check-if-it-is-a-straight-line/

class Solution:
    def checkStraightLine(self, coordinates: list[list[int]]) -> bool:
        dx = coordinates[1][0] - coordinates[0][0]
        dy = coordinates[1][1] - coordinates[0][1]
        for x, y in coordinates[2:]:
            if (x - coordinates[0][0]) * dy != (y - coordinates[0][1]) * dx:
                return False
        return True
