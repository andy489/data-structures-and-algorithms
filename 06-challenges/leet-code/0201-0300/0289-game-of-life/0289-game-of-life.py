# https://leetcode.com/problems/game-of-life/

class Solution:
    def gameOfLife(self, board: list[list[int]]) -> None:
        m, n = len(board), len(board[0])
        dirs = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
        for r in range(m):
            for c in range(n):
                live = sum(
                    1 for dr, dc in dirs
                    if 0 <= r+dr < m and 0 <= c+dc < n and abs(board[r+dr][c+dc]) == 1
                )
                if board[r][c] == 1 and (live < 2 or live > 3):
                    board[r][c] = -1
                elif board[r][c] == 0 and live == 3:
                    board[r][c] = 2
        for r in range(m):
            for c in range(n):
                if board[r][c] == -1:
                    board[r][c] = 0
                elif board[r][c] == 2:
                    board[r][c] = 1
