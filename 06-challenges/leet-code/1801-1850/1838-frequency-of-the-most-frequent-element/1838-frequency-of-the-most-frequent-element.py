# https://leetcode.com/problems/frequency-of-the-most-frequent-element/

class Solution:
    def maxFrequency(self, nums: list[int], k: int) -> int:
        nums.sort()
        l = 0
        window_sum = 0
        ans = 1
        for r, v in enumerate(nums):
            window_sum += v
            while v * (r - l + 1) - window_sum > k:
                window_sum -= nums[l]
                l += 1
            ans = max(ans, r - l + 1)
        return ans
