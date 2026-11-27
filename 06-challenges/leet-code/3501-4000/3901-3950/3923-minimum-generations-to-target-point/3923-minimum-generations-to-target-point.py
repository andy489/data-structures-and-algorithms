# https://leetcode.com/problems/minimum-generations-to-target-point/

class Solution:
    def minGenerations(self, points: list[list[int]], target: list[int]) -> int:
        known = set()
        all_pts = []
        for p in points:
            key = tuple(p)
            if key not in known:
                known.add(key)
                all_pts.append(p)
        t_key = tuple(target)
        if t_key in known:
            return 0
        for gen in range(1, 1001):
            size = len(all_pts)
            new_points = []
            for i in range(size):
                for j in range(i + 1, size):
                    a, b = all_pts[i], all_pts[j]
                    c = ((a[0] + b[0]) // 2, (a[1] + b[1]) // 2, (a[2] + b[2]) // 2)
                    if c == t_key:
                        return gen
                    if c not in known:
                        known.add(c)
                        new_points.append(list(c))
            if not new_points:
                return -1
            all_pts.extend(new_points)
        return -1
