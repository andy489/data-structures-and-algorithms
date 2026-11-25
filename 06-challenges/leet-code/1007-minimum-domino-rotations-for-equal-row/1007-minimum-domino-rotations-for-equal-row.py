# https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

class Solution:
    def minDominoRotations(self, tops: list[int], bottoms: list[int]) -> int:
        def check(v):
            rot_top = rot_bot = 0
            for t, b in zip(tops, bottoms):
                if t != v and b != v:
                    return float('inf')
                if t != v:
                    rot_top += 1
                if b != v:
                    rot_bot += 1
            return min(rot_top, rot_bot)
        ans = min(check(tops[0]), check(bottoms[0]))
        return ans if ans != float('inf') else -1
