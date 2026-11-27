# https://leetcode.com/problems/minimum-time-to-repair-cars/
import math

class Solution:
    def repairCars(self, ranks: list[int], cars: int) -> int:
        def can_finish(t: int) -> bool:
            return sum(int(math.sqrt(t // r)) for r in ranks) >= cars

        lo, hi = 1, min(ranks) * cars * cars
        while lo < hi:
            mid = (lo + hi) // 2
            if can_finish(mid):
                hi = mid
            else:
                lo = mid + 1
        return lo
