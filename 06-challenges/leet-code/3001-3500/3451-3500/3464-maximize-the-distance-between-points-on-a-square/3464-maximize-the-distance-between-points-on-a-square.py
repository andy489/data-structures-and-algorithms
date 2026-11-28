# https://leetcode.com/problems/maximize-the-distance-between-points-on-a-square/

class Solution:
    def maxDistance(self, side: int, points: list[list[int]], k: int) -> int:
        n = len(points)
        # Map each boundary point to 1D perimeter position
        def to_pos(x, y):
            if y == 0:
                return x
            elif x == side:
                return side + y
            elif y == side:
                return 2 * side + (side - x)
            else:
                return 3 * side + (side - y)

        pos = sorted(to_pos(x, y) for x, y in points)
        perim = 4 * side

        def can_place(d):
            # Try each starting point
            for start in range(n):
                count = 1
                last = pos[start]
                for i in range(start + 1, start + n):
                    cur = pos[i % n]
                    gap = (cur - last) % perim
                    if gap >= d:
                        count += 1
                        last = cur
                if count >= k:
                    return True
            return False

        lo, hi, ans = 1, 2 * side, 0
        while lo <= hi:
            mid = (lo + hi) // 2
            if can_place(mid):
                ans = mid
                lo = mid + 1
            else:
                hi = mid - 1
        return ans
