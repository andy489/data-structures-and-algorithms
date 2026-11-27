# https://leetcode.com/problems/angles-of-a-triangle/
class Solution:
    def anglesOfTriangle(self, sides: list[int]) -> list[float]:
        import math
        a, b, c = sides[0], sides[1], sides[2]

        # Check triangle inequality (positive area)
        if a + b <= c or a + c <= b or b + c <= a:
            return []

        # Law of cosines
        angle_a = math.degrees(math.acos((b * b + c * c - a * a) / (2.0 * b * c)))
        angle_b = math.degrees(math.acos((a * a + c * c - b * b) / (2.0 * a * c)))
        angle_c = 180.0 - angle_a - angle_b

        return sorted([angle_a, angle_b, angle_c])
