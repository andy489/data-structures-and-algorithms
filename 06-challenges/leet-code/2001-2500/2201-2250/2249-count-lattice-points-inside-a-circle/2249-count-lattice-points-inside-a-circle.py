# https://leetcode.com/problems/count-lattice-points-inside-a-circle/

class Solution:
    def countLatticePoints(self, circles: list[list[int]]) -> int:
        seen = set()
        for cx, cy, r in circles:
            for x in range(cx - r, cx + r + 1):
                for y in range(cy - r, cy + r + 1):
                    if (x - cx) ** 2 + (y - cy) ** 2 <= r * r:
                        seen.add((x, y))
        return len(seen)
