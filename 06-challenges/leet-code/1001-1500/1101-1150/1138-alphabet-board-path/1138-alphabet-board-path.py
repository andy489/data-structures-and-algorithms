# https://leetcode.com/problems/alphabet-board-path/

class Solution:
    def alphabetBoardPath(self, target: str) -> str:
        res = []
        cr = cc = 0
        for ch in target:
            idx = ord(ch) - ord('a')
            tr, tc = divmod(idx, 5)
            dr, dc = tr - cr, tc - cc
            if dr < 0:
                res.append('U' * (-dr))
            if dc < 0:
                res.append('L' * (-dc))
            if dr > 0:
                res.append('D' * dr)
            if dc > 0:
                res.append('R' * dc)
            res.append('!')
            cr, cc = tr, tc
        return ''.join(res)
