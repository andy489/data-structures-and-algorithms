# https://leetcode.com/problems/best-position-for-a-service-centre/

import math

class Solution:
    def getMinDistSum(self, positions) -> float:
        n = len(positions)
        x = sum(p[0] for p in positions) / n
        y = sum(p[1] for p in positions) / n

        def total_dist(cx, cy):
            return sum(math.hypot(cx - p[0], cy - p[1]) for p in positions)

        step = 1.0
        while step > 1e-6:
            nx, ny, total_w = 0.0, 0.0, 0.0
            for p in positions:
                d = math.hypot(x - p[0], y - p[1])
                if d < 1e-9:
                    continue
                w = 1.0 / d
                nx += w * p[0]
                ny += w * p[1]
                total_w += w
            if total_w < 1e-9:
                break
            nx /= total_w
            ny /= total_w
            if total_dist(nx, ny) >= total_dist(x, y):
                step *= 0.5
            else:
                x, y = nx, ny
        return total_dist(x, y)
