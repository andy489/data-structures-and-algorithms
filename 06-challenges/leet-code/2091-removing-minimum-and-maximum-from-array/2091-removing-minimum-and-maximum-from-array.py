# https://leetcode.com/problems/removing-minimum-and-maximum-from-array/

class Solution:
    def minimumDeletions(self, nums: list[int]) -> int:
        n = len(nums)
        min_i = nums.index(min(nums))
        max_i = nums.index(max(nums))
        left = max(min_i, max_i) + 1
        right = n - min(min_i, max_i)
        both = min(min_i, max_i) + 1 + n - max(min_i, max_i)
        return min(left, right, both)
