# https://leetcode.com/problems/minimum-area-rectangle-ii/

import math

class Solution:
    def minAreaFreeRect(self, points: list[list[int]]) -> float:
        point_set = {(x, y) for x, y in points}
        ans = float('inf')
        n = len(points)
        for i in range(n):
            for j in range(i + 1, n):
                for k in range(j + 1, n):
                    A, B, C = points[i], points[j], points[k]
                    for vtx, p1, p2 in [(A,B,C),(B,A,C),(C,A,B)]:
                        v1 = (p1[0]-vtx[0], p1[1]-vtx[1])
                        v2 = (p2[0]-vtx[0], p2[1]-vtx[1])
                        if v1[0]*v2[0] + v1[1]*v2[1] == 0:
                            d4 = (p1[0]+p2[0]-vtx[0], p1[1]+p2[1]-vtx[1])
                            if d4 in point_set:
                                area = math.sqrt(v1[0]**2+v1[1]**2) * math.sqrt(v2[0]**2+v2[1]**2)
                                ans = min(ans, area)
        return 0 if ans == float('inf') else ans
