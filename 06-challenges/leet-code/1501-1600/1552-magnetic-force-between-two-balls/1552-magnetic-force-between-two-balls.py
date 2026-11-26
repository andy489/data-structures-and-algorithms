# https://leetcode.com/problems/magnetic-force-between-two-balls/

class Solution:
    def maxDistance(self, position: list[int], m: int) -> int:
        position.sort()

        def can_place(min_dist: int) -> bool:
            count, last = 1, position[0]
            for p in position[1:]:
                if p - last >= min_dist:
                    count += 1
                    last = p
                    if count == m:
                        return True
            return count >= m

        lo, hi = 1, position[-1] - position[0]
        while lo < hi:
            mid = (lo + hi + 1) // 2
            if can_place(mid):
                lo = mid
            else:
                hi = mid - 1
        return lo
