# https://leetcode.com/problems/count-elements-with-maximum-frequency/

class Solution:
    def maxFrequencyElements(self, nums: list[int]) -> int:
        from collections import Counter
        freq = Counter(nums)
        max_freq = max(freq.values())
        return sum(f for f in freq.values() if f == max_freq)
