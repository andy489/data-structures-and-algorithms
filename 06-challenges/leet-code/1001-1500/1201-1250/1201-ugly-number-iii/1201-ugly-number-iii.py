# https://leetcode.com/problems/ugly-number-iii/

class Solution:
    def nthUglyNumber(self, n: int, a: int, b: int) -> int:
        from math import gcd
        lcm = a * b // gcd(a, b)
        lo, hi = 1, n * min(a, b)
        while lo < hi:
            mid = (lo + hi) // 2
            if mid // a + mid // b - mid // lcm >= n:
                hi = mid
            else:
                lo = mid + 1
        return lo
