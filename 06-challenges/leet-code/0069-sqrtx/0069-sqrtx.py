# https://leetcode.com/problems/sqrtx/

# Solution: Binary Search — O(log x) time, O(1) space
class Solution:
    def mySqrt(self, x: int) -> int:
        if x < 2:
            return x
        lo, hi = 1, x // 2
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            sq = mid * mid
            if sq == x:
                return mid
            elif sq < x:
                lo = mid + 1
            else:
                hi = mid - 1
        return hi
