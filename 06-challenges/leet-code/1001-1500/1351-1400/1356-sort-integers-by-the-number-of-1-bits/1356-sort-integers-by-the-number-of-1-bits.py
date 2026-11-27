# https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/

class Solution:
    def sortByBits(self, arr: list[int]) -> list[int]:
        return sorted(arr, key=lambda x: (bin(x).count('1'), x))
