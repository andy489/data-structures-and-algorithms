# https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

# Solution: Unified Binary Search with advance predicate — O(log n) time, O(1) space
from typing import Callable

class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        # advance(val, target) == True  →  mid is too far left, move lo up
        # lower bound: advance when val <  target (stop at first equal)
        # upper bound: advance when val <= target (stop after last equal)
        def bound(advance: Callable[[int, int], bool]) -> int:
            lo, hi, res = 0, len(nums) - 1, -1
            while lo <= hi:
                mid = (lo + hi) // 2
                if nums[mid] == target:
                    res = mid
                if advance(nums[mid], target):
                    lo = mid + 1
                else:
                    hi = mid - 1
            return res

        return [
            bound(lambda val, t: val < t),
            bound(lambda val, t: val <= t),
        ]


# Solution 2: Lower Bound with target ± 0.5 — O(log n) time, O(1) space
class Solution2:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        def lower_bound(x: float) -> int:
            lo, hi = 0, len(nums) - 1
            while lo <= hi:
                mid = (lo + hi) // 2
                if nums[mid] < x:
                    lo = mid + 1
                else:
                    hi = mid - 1
            return lo

        first = lower_bound(target - 0.5)
        last  = lower_bound(target + 0.5) - 1
        if first > last:
            return [-1, -1]
        return [first, last]
