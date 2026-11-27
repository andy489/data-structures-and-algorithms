# https://leetcode.com/problems/minimum-garden-perimeter-to-collect-enough-apples/
class Solution:
    def minimumPerimeter(self, neededApples: int) -> int:
        lo, hi = 1, 100000
        while lo < hi:
            mid = (lo + hi) // 2
            if 2 * mid * (mid + 1) * (2 * mid + 1) >= neededApples:
                hi = mid
            else:
                lo = mid + 1
        return 8 * lo
