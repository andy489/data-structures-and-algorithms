# https://leetcode.com/problems/rotate-function/

class Solution:
    def maxRotateFunction(self, nums: list[int]) -> int:
        n = len(nums)
        total = sum(nums)
        f = sum(i * v for i, v in enumerate(nums))
        best = f
        for k in range(1, n):
            f = f + total - n * nums[n - k]
            if f > best:
                best = f
        return best
