# https://leetcode.com/problems/max-points-on-a-line/

from math import gcd

# Solution: Slope HashMap per anchor — O(n^2) time, O(n) space
class Solution:
    def maxPoints(self, points: list[list[int]]) -> int:
        n = len(points)
        if n <= 2:
            return n
        result = 2
        for i in range(n):
            slope_count: dict[tuple, int] = {}
            for j in range(i + 1, n):
                dx = points[j][0] - points[i][0]
                dy = points[j][1] - points[i][1]
                g = gcd(abs(dx), abs(dy))
                if g:
                    dx //= g; dy //= g
                if dx < 0:
                    dx, dy = -dx, -dy
                elif dx == 0:
                    dy = abs(dy)
                key = (dx, dy)
                slope_count[key] = slope_count.get(key, 0) + 1
            local_max = max(slope_count.values(), default=0)
            result = max(result, local_max + 1)
        return result
