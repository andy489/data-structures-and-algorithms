# https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/

class Solution:
    def maxAbsoluteSum(self, nums: list[int]) -> int:
        max_sum = min_sum = 0
        cur_max = cur_min = 0
        for n in nums:
            cur_max = max(cur_max + n, n)
            max_sum = max(max_sum, cur_max)
            cur_min = min(cur_min + n, n)
            min_sum = min(min_sum, cur_min)
        return max(max_sum, -min_sum)
