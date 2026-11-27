# https://leetcode.com/problems/matrix-cells-in-distance-order/

class Solution:
    def allCellsDistOrder(self, rows: int, cols: int, rCenter: int, cCenter: int) -> list[list[int]]:
        cells = [[r, c] for r in range(rows) for c in range(cols)]
        cells.sort(key=lambda rc: abs(rc[0] - rCenter) + abs(rc[1] - cCenter))
        return cells
