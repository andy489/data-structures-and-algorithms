# https://leetcode.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard/

class Solution:
    def numPoints(self, darts: list[list[int]], r: int) -> int:
        import math
        n = len(darts)
        ans = 1
        def centers(a, b):
            mx, my = (a[0]+b[0])/2, (a[1]+b[1])/2
            dx, dy = b[0]-a[0], b[1]-a[1]
            d = math.sqrt(dx*dx+dy*dy)
            if d > 2*r: return []
            h = math.sqrt(max(0, r*r - d*d/4))
            return [(mx+h*(-dy/d), my+h*(dx/d)), (mx-h*(-dy/d), my-h*(dx/d))]
        def count(cx, cy):
            return sum((p[0]-cx)**2+(p[1]-cy)**2 <= r*r+1e-6 for p in darts)
        for i in range(n):
            for j in range(i+1, n):
                for cx, cy in centers(darts[i], darts[j]):
                    ans = max(ans, count(cx, cy))
        return ans
