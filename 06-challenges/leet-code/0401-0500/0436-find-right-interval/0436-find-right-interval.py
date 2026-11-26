# https://leetcode.com/problems/find-right-interval/

import bisect

class Solution:
    def findRightInterval(self, intervals: list[list[int]]) -> list[int]:
        starts = sorted((interval[0], i) for i, interval in enumerate(intervals))
        start_vals = [s for s, _ in starts]

        result = []
        for _, end in intervals:
            pos = bisect.bisect_left(start_vals, end)
            result.append(starts[pos][1] if pos < len(starts) else -1)
        return result
