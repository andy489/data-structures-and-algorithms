# https://leetcode.com/problems/sort-matrix-by-diagonals/
from collections import defaultdict
from typing import List

class Solution:
    def sortMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)
        diags = defaultdict(list)

        for i in range(n):
            for j in range(n):
                diags[i - j].append(grid[i][j])

        for key in diags:
            if key >= 0:
                diags[key].sort(reverse=True)
            else:
                diags[key].sort()

        idx = defaultdict(int)
        res = [[0] * n for _ in range(n)]
        for i in range(n):
            for j in range(n):
                key = i - j
                res[i][j] = diags[key][idx[key]]
                idx[key] += 1

        return res
