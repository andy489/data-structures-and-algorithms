# https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/

class Solution:
    def maxValue(self, n: int, index: int, maxSum: int) -> int:
        def sum_side(v: int, length: int) -> int:
            if v >= length:
                lo = v - length + 1
                return (v + lo) * length // 2
            return v * (v + 1) // 2 + (length - v)

        left, right = index, n - 1 - index
        lo, hi = 1, maxSum
        while lo < hi:
            mid = (lo + hi + 1) // 2
            total = sum_side(mid, left + 1) + sum_side(mid, right + 1) - mid
            if total <= maxSum:
                lo = mid
            else:
                hi = mid - 1
        return lo
