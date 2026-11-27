# https://leetcode.com/problems/unique-number-of-occurrences/

class Solution:
    def uniqueOccurrences(self, arr: list[int]) -> bool:
        from collections import Counter
        freq = Counter(arr)
        return len(set(freq.values())) == len(freq)
