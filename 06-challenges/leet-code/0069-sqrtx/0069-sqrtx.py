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


# Solution 2: Newton's Method, integer — O(log log x) time, O(1) space
# Implicit epsilon = 1: stop when r*r <= x (r can't get closer than 1 in integer arithmetic)
# r_next = (r + x/r) / 2  converges quadratically; AM-GM guarantees r >= sqrt(x) always
class Solution2:
    def mySqrt(self, x: int) -> int:
        if x == 0:
            return 0
        r = x
        while r * r > x:
            r = (r + x // r) // 2
        return r


# Solution 3: Newton's Method, floating-point with explicit epsilon — O(log log(x/eps)) time, O(1) space
# General version: stop when |r*r - x| < eps.
# eps = 1e-5 gives 5 decimal places of precision; each extra decimal place costs ~1 iteration.
class Solution3:
    def mySqrt(self, x: float, eps: float = 1e-5) -> float:
        if x == 0:
            return 0
        r = x
        while abs(r * r - x) > eps:
            r = (r + x / r) / 2.0
        return r
