# https://leetcode.com/problems/data-stream-as-disjoint-intervals/

from sortedcontainers import SortedDict

class SummaryRanges:
    def __init__(self):
        self.intervals = SortedDict()

    def addNum(self, value: int) -> None:
        d = self.intervals
        keys = d.keys()
        idx = d.bisect_right(value)

        # Check if value is already covered by predecessor interval
        if idx > 0:
            lo_start = keys[idx - 1]
            lo_end = d[lo_start]
            if lo_end >= value:
                return

        start, end = value, value

        # Merge with predecessor if adjacent/overlapping
        if idx > 0:
            lo_start = keys[idx - 1]
            lo_end = d[lo_start]
            if lo_end + 1 >= value:
                start = lo_start
                end = max(end, lo_end)
                del d[lo_start]
                idx -= 1

        # Merge with successor if adjacent/overlapping
        if idx < len(d):
            hi_start = keys[idx]
            hi_end = d[hi_start]
            if hi_start <= value + 1:
                end = max(end, hi_end)
                del d[hi_start]

        d[start] = end

    def getIntervals(self) -> list[list[int]]:
        return [[s, e] for s, e in self.intervals.items()]
