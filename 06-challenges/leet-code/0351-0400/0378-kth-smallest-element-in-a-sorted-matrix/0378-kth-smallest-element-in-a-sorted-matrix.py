# https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

import heapq

class Solution:
    def kthSmallest(self, matrix: list[list[int]], k: int) -> int:
        n = len(matrix)
        lo, hi = matrix[0][0], matrix[n - 1][n - 1]
        while lo < hi:
            mid = (lo + hi) // 2
            if self._count_le(matrix, mid, n) < k:
                lo = mid + 1
            else:
                hi = mid
        return lo

    def _count_le(self, matrix, mid, n):
        count, row, col = 0, 0, n - 1
        while row < n and col >= 0:
            if matrix[row][col] <= mid:
                count += col + 1
                row += 1
            else:
                col -= 1
        return count
