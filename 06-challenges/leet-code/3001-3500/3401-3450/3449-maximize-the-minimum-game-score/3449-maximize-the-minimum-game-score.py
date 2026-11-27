# https://leetcode.com/problems/maximize-the-minimum-game-score/
from typing import List
import math

class Solution:
    def maxScore(self, points: List[int], m: int) -> int:
        def can_achieve(min_score):
            moves = m
            for p in points:
                needed = math.ceil(min_score / p)
                moves -= 2 * needed - 1
                if moves < 0:
                    return False
            return True

        lo, hi = 0, (m + 1) * max(points)
        while lo < hi:
            mid = (lo + hi + 1) // 2
            if can_achieve(mid):
                lo = mid
            else:
                hi = mid - 1

        return lo
