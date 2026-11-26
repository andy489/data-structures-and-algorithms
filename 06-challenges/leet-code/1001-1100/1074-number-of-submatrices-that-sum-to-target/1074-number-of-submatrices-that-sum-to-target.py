# https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/

class Solution:
    def numSubmatrixSumTarget(self, matrix: list[list[int]], target: int) -> int:
        from collections import defaultdict
        m, n = len(matrix), len(matrix[0])
        count = 0
        for r1 in range(m):
            col_sum = [0] * n
            for r2 in range(r1, m):
                for c in range(n):
                    col_sum[c] += matrix[r2][c]
                prefix_count = defaultdict(int)
                prefix_count[0] = 1
                prefix = 0
                for s in col_sum:
                    prefix += s
                    count += prefix_count[prefix - target]
                    prefix_count[prefix] += 1
        return count
