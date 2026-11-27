# https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k/

class Solution:
    def maxSubarraySum(self, nums: list[int], k: int) -> int:
        min_by_rem = [float('inf')] * k
        min_by_rem[0] = 0

        prefix = 0
        max_sum = float('-inf')
        for i in range(1, len(nums) + 1):
            prefix += nums[i - 1]
            r = i % k
            if min_by_rem[r] != float('inf'):
                max_sum = max(max_sum, prefix - min_by_rem[r])
            min_by_rem[r] = min(min_by_rem[r], prefix)

        return max_sum
