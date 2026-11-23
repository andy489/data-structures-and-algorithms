# https://leetcode.com/problems/heaters/

import bisect

class Solution:
    def findRadius(self, houses: list[int], heaters: list[int]) -> int:
        heaters.sort()
        min_radius = 0
        for house in houses:
            pos = bisect.bisect_left(heaters, house)
            dist_right = heaters[pos] - house if pos < len(heaters) else float('inf')
            dist_left = house - heaters[pos - 1] if pos > 0 else float('inf')
            min_radius = max(min_radius, min(dist_left, dist_right))
        return min_radius
