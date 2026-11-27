# https://leetcode.com/problems/zigzag-conversion/

class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s

        rows = [[] for _ in range(numRows)]
        row = 0
        step = 1

        for c in s:
            rows[row].append(c)
            if row == 0:
                step = 1
            if row == numRows - 1:
                step = -1
            row += step

        return ''.join(''.join(r) for r in rows)
