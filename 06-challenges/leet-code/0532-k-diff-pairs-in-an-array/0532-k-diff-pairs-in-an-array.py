# https://leetcode.com/problems/k-diff-pairs-in-an-array/

from collections import Counter

class Solution:
    def findPairs(self, nums: list[int], k: int) -> int:
        freq = Counter(nums)
        count = 0
        for num in freq:
            if k == 0:
                if freq[num] >= 2:
                    count += 1
            else:
                if num + k in freq:
                    count += 1
        return count
