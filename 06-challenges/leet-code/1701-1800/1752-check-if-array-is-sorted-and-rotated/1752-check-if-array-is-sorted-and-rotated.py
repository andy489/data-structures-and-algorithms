# https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

class Solution:
    def check(self, nums: list[int]) -> bool:
        n = len(nums)
        descents = sum(1 for i in range(n) if nums[i] > nums[(i + 1) % n])
        return descents <= 1
