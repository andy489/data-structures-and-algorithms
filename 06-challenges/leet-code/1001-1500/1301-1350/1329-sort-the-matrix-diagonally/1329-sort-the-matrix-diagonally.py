# https://leetcode.com/problems/sort-the-matrix-diagonally/

from collections import defaultdict

class Solution:
    def diagonalSort(self, mat: list[list[int]]) -> list[list[int]]:
        m, n = len(mat), len(mat[0])
        diags = defaultdict(list)
        for i in range(m):
            for j in range(n):
                diags[i-j].append(mat[i][j])
        for d in diags.values():
            d.sort()
        idx = defaultdict(int)
        for i in range(m):
            for j in range(n):
                k = i - j
                mat[i][j] = diags[k][idx[k]]
                idx[k] += 1
        return mat
