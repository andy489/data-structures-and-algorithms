# https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

class Solution:
    def minDays(self, bloomDay: list[int], m: int, k: int) -> int:
        if m * k > len(bloomDay):
            return -1
        def can_make(day):
            bouquets = consecutive = 0
            for d in bloomDay:
                if d <= day:
                    consecutive += 1
                    if consecutive == k:
                        bouquets += 1
                        consecutive = 0
                else:
                    consecutive = 0
            return bouquets >= m
        lo, hi = 1, max(bloomDay)
        while lo < hi:
            mid = (lo + hi) // 2
            if can_make(mid):
                hi = mid
            else:
                lo = mid + 1
        return lo
