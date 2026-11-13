# https://leetcode.com/problems/rotate-image/

class Solution:
    def rotate(self, matrix: list[list[int]]) -> None:
        n = len(matrix)
        # transpose: matrix[i][j] <-> matrix[j][i]
        for i in range(n):
            for j in range(i + 1, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        # reverse each row
        for row in matrix:
            row.reverse()
