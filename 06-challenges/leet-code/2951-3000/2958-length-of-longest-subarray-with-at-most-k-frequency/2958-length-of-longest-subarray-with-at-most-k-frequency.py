# https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/
class Solution:
    def maxSubarrayLength(self, nums: list[int], k: int) -> int:
        freq = {}
        left = 0
        max_len = 0
        for right, x in enumerate(nums):
            freq[x] = freq.get(x, 0) + 1
            while freq[x] > k:
                freq[nums[left]] -= 1
                left += 1
            max_len = max(max_len, right - left + 1)
        return max_len
