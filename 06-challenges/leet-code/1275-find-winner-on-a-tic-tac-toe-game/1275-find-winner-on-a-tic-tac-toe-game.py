# https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

class Solution:
    def tictactoe(self, moves: list[list[int]]) -> str:
        row, col, diag, anti = [0]*3, [0]*3, 0, 0
        for i, (r, c) in enumerate(moves):
            v = 1 if i % 2 == 0 else -1
            row[r] += v; col[c] += v
            if r == c: diag += v
            if r + c == 2: anti += v
        for i in range(3):
            if abs(row[i]) == 3 or abs(col[i]) == 3:
                return 'B' if len(moves) % 2 == 0 else 'A'
        if abs(diag) == 3 or abs(anti) == 3:
            return 'B' if len(moves) % 2 == 0 else 'A'
        return 'Draw' if len(moves) == 9 else 'Pending'
