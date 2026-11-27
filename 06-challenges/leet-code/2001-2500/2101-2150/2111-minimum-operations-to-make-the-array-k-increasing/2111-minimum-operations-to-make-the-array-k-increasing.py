# https://leetcode.com/problems/minimum-operations-to-make-the-array-k-increasing/

import bisect

# Solution: LNDS on each stride — O(n log n) time, O(n) space
class Solution:
    def kIncreasing(self, arr: list[int], k: int) -> int:
        def lnds(seq):
            tails = []
            for x in seq:
                # Find first tail strictly greater than x (allow equal → bisect_right)
                pos = bisect.bisect_right(tails, x)
                if pos == len(tails):
                    tails.append(x)
                else:
                    tails[pos] = x
            return len(tails)

        n = len(arr)
        ops = 0
        for r in range(k):
            sub = arr[r::k]
            ops += len(sub) - lnds(sub)
        return ops
