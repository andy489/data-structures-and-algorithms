# https://leetcode.com/problems/champagne-tower/

class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        row = [float(poured)]
        for i in range(query_row):
            nxt = [0.0] * (i + 2)
            for j, v in enumerate(row):
                if v > 1:
                    overflow = (v - 1) / 2
                    nxt[j] += overflow
                    nxt[j + 1] += overflow
            row = nxt
        return min(1.0, row[query_glass])
