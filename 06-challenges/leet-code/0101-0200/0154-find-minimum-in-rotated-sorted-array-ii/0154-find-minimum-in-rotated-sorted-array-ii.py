# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

# Solution: Binary search with duplicate handling — O(n) worst, O(log n) avg, O(1) space
class Solution:
    def findMin(self, nums: list[int]) -> int:
        lo, hi = 0, len(nums) - 1
        while lo < hi:
            mid = (lo + hi) // 2
            if nums[mid] > nums[hi]:
                lo = mid + 1
            elif nums[mid] < nums[hi]:
                hi = mid
            else:
                hi -= 1
        return nums[lo]
