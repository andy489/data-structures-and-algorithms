# https://leetcode.com/problems/non-overlapping-intervals/

class Solution:
    def eraseOverlapIntervals(self, intervals: list[list[int]]) -> int:
        intervals.sort(key=lambda x: x[1])
        removed = 0
        prev_end = float('-inf')
        for start, end in intervals:
            if start >= prev_end:
                prev_end = end
            else:
                removed += 1
        return removed
