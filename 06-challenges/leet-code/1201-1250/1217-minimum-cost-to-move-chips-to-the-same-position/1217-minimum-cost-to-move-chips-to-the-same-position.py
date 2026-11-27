# https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/

class Solution:
    def minCostToMoveChips(self, position: list[int]) -> int:
        odd = sum(p % 2 for p in position)
        return min(odd, len(position) - odd)
