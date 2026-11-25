# https://leetcode.com/problems/valid-tic-tac-toe-state/

class Solution:
    def validTicTacToe(self, board: list[str]) -> bool:
        flat = ''.join(board)
        x_count = flat.count('X')
        o_count = flat.count('O')
        if o_count > x_count or x_count > o_count + 1:
            return False

        def wins(c):
            for i in range(3):
                if all(board[i][j] == c for j in range(3)):
                    return True
                if all(board[j][i] == c for j in range(3)):
                    return True
            return (board[0][0] == board[1][1] == board[2][2] == c or
                    board[0][2] == board[1][1] == board[2][0] == c)

        x_wins = wins('X')
        o_wins = wins('O')
        if x_wins and o_wins:
            return False
        if x_wins and x_count != o_count + 1:
            return False
        if o_wins and x_count != o_count:
            return False
        return True
