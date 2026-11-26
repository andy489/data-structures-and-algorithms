# https://leetcode.com/problems/two-best-non-overlapping-events/

class Solution:
    def maxTwoEvents(self, events: list[list[int]]) -> int:
        import bisect
        events.sort(key=lambda e: e[1])
        n = len(events)
        pref = [0] * n
        pref[0] = events[0][2]
        for i in range(1, n):
            pref[i] = max(pref[i-1], events[i][2])
        ends = [e[1] for e in events]
        res = 0
        for i in range(n):
            val = events[i][2]
            res = max(res, val)
            j = bisect.bisect_left(ends, events[i][0]) - 1
            if j >= 0:
                res = max(res, val + pref[j])
        return res
