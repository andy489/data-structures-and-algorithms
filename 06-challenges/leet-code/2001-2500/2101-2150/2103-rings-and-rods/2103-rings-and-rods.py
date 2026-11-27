# https://leetcode.com/problems/rings-and-rods/

# Solution: Bitmask per Rod — O(n) time, O(1) space
class Solution:
    def countPoints(self, rings: str) -> int:
        mask = [0] * 10
        color_bit = {'R': 1, 'G': 2, 'B': 4}

        for i in range(0, len(rings), 2):
            color = rings[i]
            rod = int(rings[i + 1])
            mask[rod] |= color_bit[color]

        return sum(1 for m in mask if m == 7)
