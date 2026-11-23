# https://leetcode.com/problems/minesweeper/

class Solution:
    def updateBoard(self, board: list[list[str]], click: list[int]) -> list[list[str]]:
        DIRS = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
        m, n = len(board), len(board[0])
        row, col = click

        if board[row][col] == 'M':
            board[row][col] = 'X'
            return board

        def dfs(r: int, c: int) -> None:
            if r < 0 or r >= m or c < 0 or c >= n or board[r][c] != 'E':
                return
            mines = sum(
                1 for dr, dc in DIRS
                if 0 <= r+dr < m and 0 <= c+dc < n and board[r+dr][c+dc] == 'M'
            )
            if mines > 0:
                board[r][c] = str(mines)
            else:
                board[r][c] = 'B'
                for dr, dc in DIRS:
                    dfs(r + dr, c + dc)

        dfs(row, col)
        return board
