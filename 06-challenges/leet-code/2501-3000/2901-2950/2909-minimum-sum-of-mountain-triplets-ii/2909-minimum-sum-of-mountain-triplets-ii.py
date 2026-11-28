# https://leetcode.com/problems/minimum-sum-of-mountain-triplets-ii/

class Solution:
    def minimumSum(self, nums: list[int]) -> int:
        n = len(nums)
        left_min = [float('inf')] * n
        right_min = [float('inf')] * n

        for i in range(1, n):
            left_min[i] = min(left_min[i - 1], nums[i - 1])
        for i in range(n - 2, -1, -1):
            right_min[i] = min(right_min[i + 1], nums[i + 1])

        min_sum = float('inf')
        for j in range(1, n - 1):
            if left_min[j] < nums[j] and right_min[j] < nums[j]:
                min_sum = min(min_sum, left_min[j] + nums[j] + right_min[j])

        return min_sum if min_sum != float('inf') else -1
