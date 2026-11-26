# https://leetcode.com/problems/n-queens/

# Solution 1: Backtracking with Sets — O(n!) time, O(n²) space
class Solution:
    def solveNQueens(self, n: int) -> list[list[str]]:
        res = []
        queens = []
        cols, diag1, diag2 = set(), set(), set()

        def backtrack(row: int) -> None:
            if row == n:
                board = []
                for c in queens:
                    board.append('.' * c + 'Q' + '.' * (n - c - 1))
                res.append(board)
                return
            for col in range(n):
                if col in cols or (row - col) in diag1 or (row + col) in diag2:
                    continue
                queens.append(col)
                cols.add(col)
                diag1.add(row - col)
                diag2.add(row + col)
                backtrack(row + 1)
                queens.pop()
                cols.remove(col)
                diag1.remove(row - col)
                diag2.remove(row + col)

        backtrack(0)
        return res


# Solution 2: Backtracking with Bitmasks — O(n!) time, O(n²) space
class Solution2:
    def solveNQueens(self, n: int) -> list[list[str]]:
        res = []
        queens = [0] * n
        full_mask = (1 << n) - 1

        def backtrack(row: int, cols: int, diag1: int, diag2: int) -> None:
            if row == n:
                board = []
                for c in queens:
                    board.append('.' * c + 'Q' + '.' * (n - c - 1))
                res.append(board)
                return
            available = ~(cols | diag1 | diag2) & full_mask
            while available:
                bit = available & -available
                queens[row] = bit.bit_length() - 1
                backtrack(row + 1, cols | bit, (diag1 | bit) >> 1, (diag2 | bit) << 1)
                available &= available - 1

        backtrack(0, 0, 0, 0)
        return res
