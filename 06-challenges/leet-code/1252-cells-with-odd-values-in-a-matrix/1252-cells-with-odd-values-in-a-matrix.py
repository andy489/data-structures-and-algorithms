# https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/

class Solution:
    def oddCells(self, m: int, n: int, indices: list[list[int]]) -> int:
        row = [0] * m
        col = [0] * n
        for r, c in indices:
            row[r] += 1
            col[c] += 1
        odd_r = sum(r % 2 for r in row)
        odd_c = sum(c % 2 for c in col)
        return odd_r * (n - odd_c) + (m - odd_r) * odd_c
