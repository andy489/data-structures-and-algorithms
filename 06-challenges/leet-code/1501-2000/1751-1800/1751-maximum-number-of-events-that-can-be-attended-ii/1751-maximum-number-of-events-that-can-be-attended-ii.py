# https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/

import bisect

class Solution:
    def maxValue(self, events: list[list[int]], k: int) -> int:
        events.sort(key=lambda e: e[1])
        n = len(events)
        ends = [e[1] for e in events]
        dp = [[0] * (k + 1) for _ in range(n + 1)]
        for i in range(1, n + 1):
            start, end, val = events[i - 1]
            # Find last event ending strictly before start
            prev = bisect.bisect_left(ends, start, 0, i - 1)
            for j in range(1, k + 1):
                dp[i][j] = max(dp[i - 1][j], dp[prev][j - 1] + val)
        return dp[n][k]
