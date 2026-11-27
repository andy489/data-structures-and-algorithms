# https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
class Solution:
    def checkValid(self, matrix: list) -> bool:
        n = len(matrix)
        expected = set(range(1, n + 1))
        for i in range(n):
            if set(matrix[i]) != expected:
                return False
            if set(matrix[j][i] for j in range(n)) != expected:
                return False
        return True
