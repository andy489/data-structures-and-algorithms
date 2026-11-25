# https://leetcode.com/problems/minimum-falling-path-sum/

class Solution:
    def minFallingPathSum(self, matrix: list) -> int:
        n = len(matrix)
        for i in range(1, n):
            for j in range(n):
                best = matrix[i-1][j]
                if j > 0:
                    best = min(best, matrix[i-1][j-1])
                if j < n-1:
                    best = min(best, matrix[i-1][j+1])
                matrix[i][j] += best
        return min(matrix[-1])
