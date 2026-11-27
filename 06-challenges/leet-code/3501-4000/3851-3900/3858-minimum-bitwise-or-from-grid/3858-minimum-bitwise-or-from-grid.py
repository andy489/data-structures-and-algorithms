# https://leetcode.com/problems/minimum-bitwise-or-from-grid/

from typing import List

class Solution:
    def minBitwiseOR(self, grid: List[List[int]]) -> int:
        reachable = {0}
        for row in grid:
            nxt = set()
            for v in reachable:
                for x in row:
                    nxt.add(v | x)
            reachable = nxt
        return min(reachable)
