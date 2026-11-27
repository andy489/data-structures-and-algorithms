# https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/

class Solution:
    def nearestValidPoint(self, x: int, y: int, points: list[list[int]]) -> int:
        best_dist, best_idx = float('inf'), -1
        for i, (a, b) in enumerate(points):
            if a == x or b == y:
                dist = abs(x - a) + abs(y - b)
                if dist < best_dist:
                    best_dist = dist
                    best_idx = i
        return best_idx
