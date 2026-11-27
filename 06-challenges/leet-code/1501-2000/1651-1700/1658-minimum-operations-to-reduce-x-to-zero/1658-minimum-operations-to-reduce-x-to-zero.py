# https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

class Solution:
    def minOperations(self, nums: list[int], x: int) -> int:
        target = sum(nums) - x
        if target < 0:
            return -1
        if target == 0:
            return len(nums)
        max_len = -1
        window_sum = 0
        l = 0
        for r in range(len(nums)):
            window_sum += nums[r]
            while window_sum > target:
                window_sum -= nums[l]
                l += 1
            if window_sum == target:
                max_len = max(max_len, r - l + 1)
        return -1 if max_len == -1 else len(nums) - max_len
