# https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

import bisect

class Solution:
    def kWeakestRows(self, mat: list[list[int]], k: int) -> list[int]:
        counts = [(bisect.bisect_right(row, 1) - bisect.bisect_left(row, 1) + row.count(1), i) for i, row in enumerate(mat)]
        counts.sort(key=lambda x: (sum(mat[x[1]]), x[1]))
        # Simpler:
        strength = [(row.count(1), i) for i, row in enumerate(mat)]
        strength.sort()
        return [i for _, i in strength[:k]]
