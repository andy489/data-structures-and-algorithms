# https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/

class Solution:
    def findKthNumber(self, m: int, n: int, k: int) -> int:
        def count(x):
            return sum(min(x // i, n) for i in range(1, m + 1))

        lo, hi = 1, m * n
        while lo < hi:
            mid = (lo + hi) // 2
            if count(mid) >= k:
                hi = mid
            else:
                lo = mid + 1
        return lo
