# https://leetcode.com/problems/split-the-array/

class Solution:
    def isPossibleToSplit(self, nums: list[int]) -> bool:
        from collections import Counter
        return max(Counter(nums).values()) <= 2
