# https://leetcode.com/problems/queens-that-can-attack-the-king/

class Solution:
    def queensAttacktheKing(self, queens: list[list[int]], king: list[int]) -> list[list[int]]:
        qset = set(map(tuple, queens))
        res = []
        for dr in [-1,0,1]:
            for dc in [-1,0,1]:
                if dr == 0 and dc == 0: continue
                r, c = king[0]+dr, king[1]+dc
                while 0 <= r < 8 and 0 <= c < 8:
                    if (r, c) in qset: res.append([r, c]); break
                    r += dr; c += dc
        return res
