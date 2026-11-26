# https://leetcode.com/problems/minimum-moves-to-convert-string/

class Solution:
    def minimumMoves(self, s: str) -> int:
        moves, i = 0, 0
        while i < len(s):
            if s[i] == 'X':
                moves += 1
                i += 3
            else:
                i += 1
        return moves
