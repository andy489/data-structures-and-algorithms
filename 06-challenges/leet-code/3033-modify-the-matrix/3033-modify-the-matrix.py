# https://leetcode.com/problems/modify-the-matrix/

class Solution:
    def modifiedMatrix(self, matrix: list[list[int]]) -> list[list[int]]:
        m, n = len(matrix), len(matrix[0])
        for j in range(n):
            col_max = max(matrix[i][j] for i in range(m))
            for i in range(m):
                if matrix[i][j] == -1:
                    matrix[i][j] = col_max
        return matrix
