# https://leetcode.com/problems/sqrtx/

# Solution 1: Binary Search — O(log x) time, O(1) space
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


# Solution 2: Newton's Method (Babylonian method, ~2000 BCE) — O(log log x) time, O(1) space
# r_next = (r + x/r) / 2  converges quadratically; AM-GM guarantees r >= sqrt(x) always
class Solution2:
    def mySqrt(self, x: int) -> int:
        if x == 0:
            return 0
        r = x
        while r * r > x:
            r = (r + x // r) // 2
        return r
