# https://leetcode.com/problems/largest-number/

# Solution: Custom Comparator Sort — O(n log n * k) time, O(n) space
from functools import cmp_to_key

class Solution:
    def largestNumber(self, nums: list[int]) -> str:
        strs = list(map(str, nums))
        strs.sort(key=cmp_to_key(lambda a, b: (1 if a + b < b + a else -1)))
        if strs[0] == '0':
            return '0'
        return ''.join(strs)
