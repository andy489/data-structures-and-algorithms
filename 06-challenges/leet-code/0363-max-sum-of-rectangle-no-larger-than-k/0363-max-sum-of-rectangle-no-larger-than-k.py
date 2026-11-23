# https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/

from sortedcontainers import SortedList
import math

class Solution:
    def maxSumSubmatrix(self, matrix: list[list[int]], k: int) -> int:
        m, n = len(matrix), len(matrix[0])
        ans = -math.inf
        for l in range(n):
            row_sum = [0] * m
            for r in range(l, n):
                for i in range(m):
                    row_sum[i] += matrix[i][r]
                sl = SortedList([0])
                prefix = 0
                for s in row_sum:
                    prefix += s
                    idx = sl.bisect_left(prefix - k)
                    if idx < len(sl):
                        ans = max(ans, prefix - sl[idx])
                    sl.add(prefix)
        return ans
