# https://leetcode.com/problems/lucky-numbers-in-a-matrix/

class Solution:
    def luckyNumbers(self, matrix: list[list[int]]) -> list[int]:
        row_mins = {min(row) for row in matrix}
        col_maxs = {max(col) for col in zip(*matrix)}
        return list(row_mins & col_maxs)
