# https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/

class Solution:
    def kthLargestValue(self, matrix: list[list[int]], k: int) -> int:
        m, n = len(matrix), len(matrix[0])
        for i in range(m):
            for j in range(1, n):
                matrix[i][j] ^= matrix[i][j - 1]
        for j in range(n):
            for i in range(1, m):
                matrix[i][j] ^= matrix[i - 1][j]
        vals = sorted(matrix[i][j] for i in range(m) for j in range(n))
        return vals[-k]
