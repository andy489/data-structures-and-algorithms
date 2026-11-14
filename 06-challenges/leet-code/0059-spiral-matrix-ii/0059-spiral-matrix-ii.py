# https://leetcode.com/problems/spiral-matrix-ii/

class Solution:
    def generateMatrix(self, n: int) -> list[list[int]]:
        matrix = [[0] * n for _ in range(n)]
        top, bottom, left, right, num = 0, n - 1, 0, n - 1, 1
        while num <= n * n:
            for c in range(left, right + 1):
                matrix[top][c] = num; num += 1
            top += 1
            for r in range(top, bottom + 1):
                matrix[r][right] = num; num += 1
            right -= 1
            for c in range(right, left - 1, -1):
                matrix[bottom][c] = num; num += 1
            bottom -= 1
            for r in range(bottom, top - 1, -1):
                matrix[r][left] = num; num += 1
            left += 1
        return matrix


# Solution 2: Recursion — O(n²) time, O(n) space
class Solution2:
    def generateMatrix(self, n: int) -> list[list[int]]:
        matrix = [[0] * n for _ in range(n)]

        def fill(offset, size, num):
            if size == 0:
                return
            if size == 1:
                matrix[offset][offset] = num
                return
            for c in range(offset, offset + size - 1):
                matrix[offset][c] = num; num += 1
            for r in range(offset, offset + size - 1):
                matrix[r][offset + size - 1] = num; num += 1
            for c in range(offset + size - 1, offset, -1):
                matrix[offset + size - 1][c] = num; num += 1
            for r in range(offset + size - 1, offset, -1):
                matrix[r][offset] = num; num += 1
            fill(offset + 1, size - 2, num)

        fill(0, n, 1)
        return matrix
