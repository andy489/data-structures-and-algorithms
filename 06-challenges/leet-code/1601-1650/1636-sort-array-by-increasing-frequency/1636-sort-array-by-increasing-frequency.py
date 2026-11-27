# https://leetcode.com/problems/sort-array-by-increasing-frequency/

class Solution:
    def frequencySort(self, nums: list[int]) -> list[int]:
        from collections import Counter
        freq = Counter(nums)
        return sorted(nums, key=lambda x: (freq[x], -x))
