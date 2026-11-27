# https://leetcode.com/problems/count-nice-pairs-in-an-array/

from collections import Counter

class Solution:
    def countNicePairs(self, nums: list[int]) -> int:
        MOD = 10**9 + 7
        rev = lambda x: int(str(x)[::-1])
        freq = Counter(x - rev(x) for x in nums)
        return sum(c * (c - 1) // 2 for c in freq.values()) % MOD
