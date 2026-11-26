# https://leetcode.com/problems/remove-covered-intervals/

class Solution:
    def removeCoveredIntervals(self, intervals: list[list[int]]) -> int:
        intervals.sort(key=lambda x: (x[0], -x[1]))
        count = max_right = 0
        for l, r in intervals:
            if r > max_right:
                count += 1
                max_right = r
        return count
