# https://leetcode.com/problems/design-spreadsheet/

class Spreadsheet:

    def __init__(self, rows: int):
        self.cells = {}

    def setCell(self, cell: str, value: int) -> None:
        self.cells[cell] = value

    def resetCell(self, cell: str) -> None:
        self.cells.pop(cell, None)

    def getValue(self, formula: str) -> int:
        expr = formula[1:]  # remove '='
        parts = expr.split('+')
        total = 0
        for part in parts:
            if part[0].isdigit():
                total += int(part)
            else:
                total += self.cells.get(part, 0)
        return total
