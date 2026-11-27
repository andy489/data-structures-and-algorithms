# https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/
class Solution:
    def minSwaps(self, nums: list) -> int:
        n = len(nums)
        k = sum(nums)
        if k == 0:
            return 0
        window_ones = sum(nums[:k])
        max_ones = window_ones
        for i in range(1, n):
            window_ones += nums[(i + k - 1) % n] - nums[i - 1]
            max_ones = max(max_ones, window_ones)
        return k - max_ones
