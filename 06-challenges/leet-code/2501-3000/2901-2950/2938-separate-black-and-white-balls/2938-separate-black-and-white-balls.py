# https://leetcode.com/problems/separate-black-and-white-balls/

class Solution:
    def minimumSteps(self, s: str) -> int:
        moves = 0
        whites = 0
        for c in s:
            if c == '0':
                whites += 1
            else:
                moves += whites
        return moves
