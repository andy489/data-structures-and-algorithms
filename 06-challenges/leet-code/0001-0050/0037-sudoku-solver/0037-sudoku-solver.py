# https://leetcode.com/problems/sudoku-solver/

class Solution:
    def solveSudoku(self, board: list[list[str]]) -> None:
        rows = [0] * 9
        cols = [0] * 9
        boxes = [0] * 9

        for r in range(9):
            for c in range(9):
                if board[r][c] != '.':
                    bit = 1 << int(board[r][c])
                    rows[r] |= bit
                    cols[c] |= bit
                    boxes[(r // 3) * 3 + (c // 3)] |= bit

        def solve(pos: int) -> bool:
            if pos == 81:
                return True
            r, c = divmod(pos, 9)
            if board[r][c] != '.':
                return solve(pos + 1)
            box = (r // 3) * 3 + (c // 3)
            for d in range(1, 10):
                bit = 1 << d
                if rows[r] & bit or cols[c] & bit or boxes[box] & bit:
                    continue
                board[r][c] = str(d)
                rows[r] |= bit
                cols[c] |= bit
                boxes[box] |= bit
                if solve(pos + 1):
                    return True
                board[r][c] = '.'
                rows[r] ^= bit
                cols[c] ^= bit
                boxes[box] ^= bit
            return False

        solve(0)
