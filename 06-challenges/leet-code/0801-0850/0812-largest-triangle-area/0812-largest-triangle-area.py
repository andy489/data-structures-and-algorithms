# https://leetcode.com/problems/largest-triangle-area/

class Solution:
    def largestTriangleArea(self, points: list[list[int]]) -> float:
        n = len(points)
        best = 0.0
        for i in range(n):
            for j in range(i + 1, n):
                for k in range(j + 1, n):
                    ax, ay = points[i]
                    bx, by = points[j]
                    cx, cy = points[k]
                    area = 0.5 * abs(ax * (by - cy) + bx * (cy - ay) + cx * (ay - by))
                    best = max(best, area)
        return best
