# https://leetcode.com/problems/set-mismatch/

from collections import Counter

class Solution:
    def findErrorNums(self, nums: list[int]) -> list[int]:
        freq = Counter(nums)
        n = len(nums)
        duplicate = missing = 0
        for i in range(1, n + 1):
            if freq[i] == 2:
                duplicate = i
            elif freq[i] == 0:
                missing = i
        return [duplicate, missing]
