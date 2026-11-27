# https://leetcode.com/problems/maximum-matrix-sum/

class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        total = 0
        min_abs = float('inf')
        neg_count = 0
        for row in matrix:
            for val in row:
                total += abs(val)
                if val < 0:
                    neg_count += 1
                min_abs = min(min_abs, abs(val))
        if neg_count % 2 == 0:
            return total
        return total - 2 * min_abs
