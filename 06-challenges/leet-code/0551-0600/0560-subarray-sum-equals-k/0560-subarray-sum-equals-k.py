# https://leetcode.com/problems/subarray-sum-equals-k/
# Solution: Prefix sum HashMap — O(n) time, O(n) space
from collections import defaultdict

class Solution:
    def subarraySum(self, nums: list[int], k: int) -> int:
        prefix_freq = defaultdict(int)
        prefix_freq[0] = 1
        total = 0
        count = 0
        for num in nums:
            total += num
            count += prefix_freq[total - k]
            prefix_freq[total] += 1
        return count
