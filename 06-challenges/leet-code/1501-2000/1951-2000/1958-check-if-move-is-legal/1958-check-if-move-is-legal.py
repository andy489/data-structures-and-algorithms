# https://leetcode.com/problems/check-if-move-is-legal/
class Solution:
    def checkMove(self, board: list[list[str]], rMove: int, cMove: int, color: str) -> bool:
        board[rMove][cMove] = color
        opposite = 'B' if color == 'W' else 'W'
        dirs = [(0,1),(0,-1),(1,0),(-1,0),(1,1),(1,-1),(-1,1),(-1,-1)]
        for dr, dc in dirs:
            r, c = rMove + dr, cMove + dc
            count = 0
            while 0 <= r < 8 and 0 <= c < 8:
                if board[r][c] == opposite:
                    count += 1
                elif board[r][c] == color:
                    if count >= 1:
                        return True
                    break
                else:
                    break
                r += dr
                c += dc
        return False
