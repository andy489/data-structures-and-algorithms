# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

# Solution: Binary search — O(log n) time, O(1) space
class Solution:
    def findMin(self, nums: list[int]) -> int:
        lo, hi = 0, len(nums) - 1
        while lo < hi:
            mid = (lo + hi) // 2
            if nums[mid] > nums[hi]:
                lo = mid + 1
            else:
                hi = mid
        return nums[lo]
