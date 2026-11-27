# https://leetcode.com/problems/binary-subarrays-with-sum/

from collections import defaultdict

class Solution:
    def numSubarraysWithSum(self, nums: list, goal: int) -> int:
        count = defaultdict(int)
        count[0] = 1
        prefix = result = 0
        for x in nums:
            prefix += x
            result += count[prefix - goal]
            count[prefix] += 1
        return result
