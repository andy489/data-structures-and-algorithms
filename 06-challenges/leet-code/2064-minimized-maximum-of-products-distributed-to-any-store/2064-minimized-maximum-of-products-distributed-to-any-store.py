# https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/

class Solution:
    def minimizedMaximum(self, n: int, quantities: list[int]) -> int:
        import math
        lo, hi = 1, max(quantities)
        while lo < hi:
            mid = (lo + hi) // 2
            if sum(math.ceil(q / mid) for q in quantities) <= n:
                hi = mid
            else:
                lo = mid + 1
        return lo
