# https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

class Solution:
    def shipWithinDays(self, weights: list[int], days: int) -> int:
        def can_ship(cap):
            needed, cur = 1, 0
            for w in weights:
                if cur + w > cap:
                    needed += 1
                    cur = 0
                cur += w
            return needed <= days
        lo, hi = max(weights), sum(weights)
        while lo < hi:
            mid = (lo + hi) // 2
            if can_ship(mid):
                hi = mid
            else:
                lo = mid + 1
        return lo
