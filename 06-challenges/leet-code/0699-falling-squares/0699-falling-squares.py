# https://leetcode.com/problems/falling-squares/

class Solution:
    def fallingSquares(self, positions: list) -> list:
        intervals = []
        result = []
        global_max = 0
        for l, side in positions:
            r = l + side
            base = 0
            for il, ir, ih in intervals:
                if il < r and ir > l:
                    base = max(base, ih)
            height = base + side
            intervals.append((l, r, height))
            global_max = max(global_max, height)
            result.append(global_max)
        return result
