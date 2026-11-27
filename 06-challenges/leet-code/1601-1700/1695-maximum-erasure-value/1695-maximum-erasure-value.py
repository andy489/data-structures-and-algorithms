# https://leetcode.com/problems/maximum-erasure-value/

class Solution:
    def maximumUniqueSubarray(self, nums: list[int]) -> int:
        last_seen = {}
        max_sum = window_sum = l = 0
        for r, v in enumerate(nums):
            if v in last_seen and last_seen[v] >= l:
                while l <= last_seen[v]:
                    window_sum -= nums[l]
                    l += 1
            window_sum += v
            last_seen[v] = r
            max_sum = max(max_sum, window_sum)
        return max_sum
