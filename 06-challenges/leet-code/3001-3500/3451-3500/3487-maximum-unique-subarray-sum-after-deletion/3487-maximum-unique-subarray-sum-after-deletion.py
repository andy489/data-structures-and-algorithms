# https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/

class Solution:
    def maxSum(self, nums: list[int]) -> int:
        positives = set(x for x in nums if x > 0)
        if positives:
            return sum(positives)
        return max(nums)
