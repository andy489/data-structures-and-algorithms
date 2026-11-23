# https://leetcode.com/problems/battleships-in-a-board/

class Solution:
    def countBattleships(self, board: list[list[str]]) -> int:
        count = 0
        for r in range(len(board)):
            for c in range(len(board[0])):
                if board[r][c] == 'X':
                    preceding_above = r > 0 and board[r - 1][c] == 'X'
                    preceding_left = c > 0 and board[r][c - 1] == 'X'
                    if not preceding_above and not preceding_left:
                        count += 1
        return count
