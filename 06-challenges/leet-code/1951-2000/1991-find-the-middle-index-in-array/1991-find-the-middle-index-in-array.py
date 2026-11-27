# https://leetcode.com/problems/find-the-middle-index-in-array/
class Solution:
    def findMiddleIndex(self, nums: list[int]) -> int:
        total = sum(nums)
        left_sum = 0
        for i, x in enumerate(nums):
            if left_sum == total - left_sum - x:
                return i
            left_sum += x
        return -1
