# https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-i/

class Solution:
    def minimumSubarrayLength(self, nums: list[int], k: int) -> int:
        min_len = float('inf')
        for i in range(len(nums)):
            or_val = 0
            for j in range(i, len(nums)):
                or_val |= nums[j]
                if or_val >= k:
                    min_len = min(min_len, j - i + 1)
                    break
        return -1 if min_len == float('inf') else min_len
