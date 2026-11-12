# https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

# Solution: Two Binary Searches (Lower/Upper Bound) — O(log n) time, O(1) space
class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        def lower_bound() -> int:
            lo, hi, res = 0, len(nums) - 1, -1
            while lo <= hi:
                mid = (lo + hi) // 2
                if nums[mid] < target:
                    lo = mid + 1
                else:
                    if nums[mid] == target:
                        res = mid
                    hi = mid - 1
            return res

        def upper_bound() -> int:
            lo, hi, res = 0, len(nums) - 1, -1
            while lo <= hi:
                mid = (lo + hi) // 2
                if nums[mid] > target:
                    hi = mid - 1
                else:
                    if nums[mid] == target:
                        res = mid
                    lo = mid + 1
            return res

        return [lower_bound(), upper_bound()]
