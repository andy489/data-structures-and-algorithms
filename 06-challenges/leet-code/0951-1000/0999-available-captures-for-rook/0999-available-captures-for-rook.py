# https://leetcode.com/problems/available-captures-for-rook/

class Solution:
    def numRookCaptures(self, board: list[list[str]]) -> int:
        rx = ry = 0
        for i in range(8):
            for j in range(8):
                if board[i][j] == 'R':
                    rx, ry = i, j
        captures = 0
        for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
            r, c = rx + dr, ry + dc
            while 0 <= r < 8 and 0 <= c < 8:
                if board[r][c] == 'B':
                    break
                if board[r][c] == 'p':
                    captures += 1
                    break
                r += dr; c += dc
        return captures
