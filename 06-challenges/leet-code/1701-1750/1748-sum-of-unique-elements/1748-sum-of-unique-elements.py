# https://leetcode.com/problems/sum-of-unique-elements/

from collections import Counter

class Solution:
    def sumOfUnique(self, nums: list[int]) -> int:
        freq = Counter(nums)
        return sum(k for k, v in freq.items() if v == 1)
