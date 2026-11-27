# https://leetcode.com/problems/k-closest-points-to-origin/

class Solution:
    def kClosest(self, points: list[list[int]], k: int) -> list[list[int]]:
        points.sort(key=lambda p: p[0]**2 + p[1]**2)
        return points[:k]
