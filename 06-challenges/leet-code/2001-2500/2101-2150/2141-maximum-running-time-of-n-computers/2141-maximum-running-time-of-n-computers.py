# https://leetcode.com/problems/maximum-running-time-of-n-computers/
class Solution:
    def maxRunTime(self, n: int, batteries: list) -> int:
        def can_run(t):
            large = sum(1 for b in batteries if b >= t)
            if large >= n:
                return True
            extra = sum(b for b in batteries if b < t)
            return extra >= (n - large) * t

        lo, hi = 0, sum(batteries) // n
        while lo < hi:
            mid = (lo + hi + 1) // 2
            if can_run(mid):
                lo = mid
            else:
                hi = mid - 1
        return lo
