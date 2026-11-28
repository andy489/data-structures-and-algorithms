# https://leetcode.com/problems/maximum-sum-with-at-most-k-elements/

import heapq

class Solution:
    def maxSum(self, grid: list[list[int]], limits: list[int], k: int) -> int:
        candidates = []
        for i, row in enumerate(grid):
            top = sorted(row, reverse=True)[:limits[i]]
            candidates.extend(top)
        candidates.sort(reverse=True)
        return sum(candidates[:k])
