# https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/

class Solution:
    def reconstructMatrix(self, upper: int, lower: int, colsum: list[int]) -> list[list[int]]:
        n = len(colsum)
        row0, row1 = [0]*n, [0]*n
        for i in range(n):
            if colsum[i] == 2:
                row0[i] = row1[i] = 1; upper -= 1; lower -= 1
            if upper < 0 or lower < 0: return []
        for i in range(n):
            if colsum[i] == 1:
                if upper > 0: row0[i] = 1; upper -= 1
                else: row1[i] = 1; lower -= 1
        return [row0, row1] if upper == 0 and lower == 0 else []
