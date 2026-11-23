# https://leetcode.com/problems/number-of-boomerangs/

class Solution:
    def numberOfBoomerangs(self, points: list[list[int]]) -> int:
        from collections import defaultdict
        result = 0
        for x1, y1 in points:
            distance_counts = defaultdict(int)
            for x2, y2 in points:
                squared_dist = (x1 - x2) ** 2 + (y1 - y2) ** 2
                distance_counts[squared_dist] += 1
            for count in distance_counts.values():
                result += count * (count - 1)
        return result
