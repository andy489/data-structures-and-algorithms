# https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/

class Solution:
    def preimageSizeFZF(self, k: int) -> int:
        def trailing_zeroes(x):
            count = 0
            while x >= 5:
                x //= 5
                count += x
            return count

        def left_bound(k):
            lo, hi = 0, 5 * (k + 1)
            while lo < hi:
                mid = (lo + hi) // 2
                if trailing_zeroes(mid) <= k:
                    lo = mid + 1
                else:
                    hi = mid
            return lo

        return left_bound(k) - left_bound(k - 1)
