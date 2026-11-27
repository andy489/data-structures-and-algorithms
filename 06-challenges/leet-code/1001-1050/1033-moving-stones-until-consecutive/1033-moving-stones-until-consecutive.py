# https://leetcode.com/problems/moving-stones-until-consecutive/

class Solution:
    def numMovesStones(self, a: int, b: int, c: int) -> list[int]:
        x, y, z = sorted([a, b, c])
        mx = (y - x - 1) + (z - y - 1)
        if z - x == 2:
            mn = 0
        elif y - x <= 2 or z - y <= 2:
            mn = 1
        else:
            mn = 2
        return [mn, mx]
