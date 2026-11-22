# https://leetcode.com/problems/minimum-size-subarray-sum/

import bisect
from itertools import accumulate

# Solution: Sliding Window — O(n) time, O(1) space
class Solution:
    def minSubArrayLen(self, target: int, nums: list[int]) -> int:
        left = 0
        total = 0
        min_len = float('inf')

        for right, num in enumerate(nums):
            total += num

            while total >= target:
                min_len = min(min_len, right - left + 1)
                total -= nums[left]
                left += 1

        return 0 if min_len == float('inf') else min_len

# Solution 2: Binary Search on Prefix Sums — O(n log n) time, O(n) space
class Solution2:
    def minSubArrayLen(self, target: int, nums: list[int]) -> int:
        prefix = list(accumulate(nums, initial=0))
        min_len = float('inf')

        for i in range(len(nums)):
            need = prefix[i] + target
            j = bisect.bisect_left(prefix, need, i + 1)

            if j <= len(nums):
                min_len = min(min_len, j - i)

        return 0 if min_len == float('inf') else min_len
