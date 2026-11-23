# https://leetcode.com/problems/construct-the-rectangle/

import math

class Solution:
    def constructRectangle(self, area: int) -> list:
        w = int(math.isqrt(area))
        while area % w != 0:
            w -= 1
        return [area // w, w]
