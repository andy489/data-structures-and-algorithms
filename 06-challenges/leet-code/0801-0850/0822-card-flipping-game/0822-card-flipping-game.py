# https://leetcode.com/problems/card-flipping-game/

class Solution:
    def flipgame(self, fronts: list[int], backs: list[int]) -> int:
        same = {f for f, b in zip(fronts, backs) if f == b}
        candidates = [x for f, b in zip(fronts, backs) for x in (f, b) if x not in same]
        return min(candidates) if candidates else 0
