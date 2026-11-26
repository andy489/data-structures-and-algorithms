# https://leetcode.com/problems/maximum-sum-circular-subarray/

class Solution:
    def maxSubarraySumCircular(self, nums: list) -> int:
        total = max_sum = cur_max = 0
        min_sum = cur_min = nums[0]
        max_sum = nums[0]
        for x in nums:
            cur_max = max(cur_max + x, x)
            max_sum = max(max_sum, cur_max)
            cur_min = min(cur_min + x, x)
            min_sum = min(min_sum, cur_min)
            total += x
        return max(max_sum, total - min_sum) if max_sum > 0 else max_sum
