# https://leetcode.com/problems/guess-number-higher-or-lower/

class Solution:
    def guessNumber(self, n: int) -> int:
        lo, hi = 1, n
        while lo <= hi:
            mid = (lo + hi) // 2
            res = guess(mid)
            if res == 0:
                return mid
            elif res == -1:
                hi = mid - 1
            else:
                lo = mid + 1
        return -1
