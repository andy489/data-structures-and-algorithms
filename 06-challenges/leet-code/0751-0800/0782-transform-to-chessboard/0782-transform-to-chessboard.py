# https://leetcode.com/problems/transform-to-chessboard/

class Solution:
    def movesToChessboard(self, board: list[list[int]]) -> int:
        n = len(board)
        for i in range(n):
            for j in range(n):
                if board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]:
                    return -1
        row_sum = sum(board[0])
        col_sum = sum(board[i][0] for i in range(n))
        if not (n // 2 <= row_sum <= (n + 1) // 2):
            return -1
        if not (n // 2 <= col_sum <= (n + 1) // 2):
            return -1
        row_mis = sum(board[i][0] == i % 2 for i in range(n))
        col_mis = sum(board[0][j] == j % 2 for j in range(n))
        if n % 2 == 1:
            if row_mis % 2 == 1:
                row_mis = n - row_mis
            if col_mis % 2 == 1:
                col_mis = n - col_mis
        else:
            row_mis = min(row_mis, n - row_mis)
            col_mis = min(col_mis, n - col_mis)
        return (row_mis + col_mis) // 2
