# https://leetcode.com/problems/spiral-matrix/

class Solution:
    def spiralOrder(self, matrix: list[list[int]]) -> list[int]:
        result = []
        top, bottom = 0, len(matrix) - 1
        left, right = 0, len(matrix[0]) - 1
        while top <= bottom and left <= right:
            for c in range(left, right + 1):
                result.append(matrix[top][c])
            top += 1
            for r in range(top, bottom + 1):
                result.append(matrix[r][right])
            right -= 1
            if top <= bottom:
                for c in range(right, left - 1, -1):
                    result.append(matrix[bottom][c])
                bottom -= 1
            if left <= right:
                for r in range(bottom, top - 1, -1):
                    result.append(matrix[r][left])
                left += 1
        return result


# Solution 2: Recursion — O(m·n) time, O(min(m,n)) space
class Solution2:
    def spiralOrder(self, matrix: list[list[int]]) -> list[int]:
        result = []

        def solve(top: int, bottom: int, left: int, right: int) -> None:
            if top > bottom or left > right:
                return
            for c in range(left, right + 1):
                result.append(matrix[top][c])
            for r in range(top + 1, bottom + 1):
                result.append(matrix[r][right])
            if top < bottom:
                for c in range(right - 1, left - 1, -1):
                    result.append(matrix[bottom][c])
            if left < right:
                for r in range(bottom - 1, top, -1):
                    result.append(matrix[r][left])
            solve(top + 1, bottom - 1, left + 1, right - 1)

        solve(0, len(matrix) - 1, 0, len(matrix[0]) - 1)
        return result

