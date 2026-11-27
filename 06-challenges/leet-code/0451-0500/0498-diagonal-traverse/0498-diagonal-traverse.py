# https://leetcode.com/problems/diagonal-traverse/

class Solution:
    def findDiagonalOrder(self, mat: list) -> list:
        m, n = len(mat), len(mat[0])
        result = []
        row = col = 0
        for _ in range(m * n):
            result.append(mat[row][col])
            if (row + col) % 2 == 0:
                # Going up-right
                if col == n - 1:
                    row += 1
                elif row == 0:
                    col += 1
                else:
                    row -= 1
                    col += 1
            else:
                # Going down-left
                if row == m - 1:
                    col += 1
                elif col == 0:
                    row += 1
                else:
                    row += 1
                    col -= 1
        return result
