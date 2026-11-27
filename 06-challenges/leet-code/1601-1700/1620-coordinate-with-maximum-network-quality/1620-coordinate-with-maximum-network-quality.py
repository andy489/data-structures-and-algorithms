# https://leetcode.com/problems/coordinate-with-maximum-network-quality/

import math

class Solution:
    def bestCoordinate(self, towers: list[list[int]], radius: int) -> list[int]:
        max_quality = 0
        best = [0, 0]
        for x in range(51):
            for y in range(51):
                quality = 0
                for tx, ty, q in towers:
                    d = math.sqrt((x - tx) ** 2 + (y - ty) ** 2)
                    if d <= radius:
                        quality += int(q / (1 + d))
                if quality > max_quality:
                    max_quality = quality
                    best = [x, y]
        return best
