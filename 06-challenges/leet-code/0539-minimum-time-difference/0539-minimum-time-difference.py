# https://leetcode.com/problems/minimum-time-difference/

class Solution:
    def findMinDifference(self, timePoints: list[str]) -> int:
        minutes = sorted(
            int(tp[:2]) * 60 + int(tp[3:]) for tp in timePoints
        )
        n = len(minutes)
        min_diff = 1440 - minutes[-1] + minutes[0]
        for i in range(1, n):
            min_diff = min(min_diff, minutes[i] - minutes[i - 1])
        return min_diff
