# https://leetcode.com/problems/matrix-diagonal-sum/

class Solution:
    def diagonalSum(self, mat: list[list[int]]) -> int:
        n = len(mat)
        total = sum(mat[i][i] + mat[i][n - 1 - i] for i in range(n))
        if n % 2 == 1:
            total -= mat[n // 2][n // 2]
        return total
