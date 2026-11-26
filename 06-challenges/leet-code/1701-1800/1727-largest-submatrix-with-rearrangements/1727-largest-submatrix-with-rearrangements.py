# https://leetcode.com/problems/largest-submatrix-with-rearrangements/

class Solution:
    def largestSubmatrix(self, matrix: list[list[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        for i in range(1, m):
            for j in range(n):
                if matrix[i][j]:
                    matrix[i][j] += matrix[i - 1][j]
        ans = 0
        for row in matrix:
            sorted_row = sorted(row, reverse=True)
            for j, h in enumerate(sorted_row):
                if h == 0:
                    break
                ans = max(ans, h * (j + 1))
        return ans
