# https://leetcode.com/problems/minimum-time-visiting-all-points/

class Solution:
    def minTimeToVisitAllPoints(self, points: list[list[int]]) -> int:
        return sum(max(abs(points[i][0]-points[i-1][0]), abs(points[i][1]-points[i-1][1])) for i in range(1, len(points)))
