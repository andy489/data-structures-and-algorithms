# https://leetcode.com/problems/maximum-profit-in-job-scheduling/

import bisect
class Solution:
    def jobScheduling(self, startTime: list[int], endTime: list[int], profit: list[int]) -> int:
        jobs = sorted(zip(endTime, startTime, profit))
        ends = [j[0] for j in jobs]
        dp = [0] * (len(jobs)+1)
        for i, (end, start, p) in enumerate(jobs):
            idx = bisect.bisect_right(ends, start, 0, i)
            dp[i+1] = max(dp[i], dp[idx] + p)
        return dp[-1]
