# https://leetcode.com/problems/relative-sort-array/

class Solution:
    def relativeSortArray(self, arr1: list[int], arr2: list[int]) -> list[int]:
        rank = {v: i for i, v in enumerate(arr2)}
        return sorted(arr1, key=lambda x: (rank[x], 0) if x in rank else (len(arr2) + x, 0))
