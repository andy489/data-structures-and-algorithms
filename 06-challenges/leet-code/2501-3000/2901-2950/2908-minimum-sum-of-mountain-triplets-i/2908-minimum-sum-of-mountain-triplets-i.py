# https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i/

class Solution:
    def minimumSum(self, nums: list[int]) -> int:
        n = len(nums)
        min_sum = float('inf')
        for i in range(n - 2):
            for j in range(i + 1, n - 1):
                for k in range(j + 1, n):
                    if nums[i] < nums[j] and nums[k] < nums[j]:
                        min_sum = min(min_sum, nums[i] + nums[j] + nums[k])
        return min_sum if min_sum != float('inf') else -1
