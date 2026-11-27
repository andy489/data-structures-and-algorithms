# https://leetcode.com/problems/make-array-strictly-increasing/

import bisect

# Solution: DP with Binary Search — O(n·m·log m) time, O(n·m) space
class Solution:
    def makeArrayIncreasing(self, arr1: list[int], arr2: list[int]) -> int:
        sorted2 = sorted(set(arr2))
        # cloned: ops_used -> min last value
        cloned = {0: -1}

        for val in arr1:
            nxt = {}
            for ops, last in cloned.items():
                # Option 1: keep val
                if val > last:
                    if ops not in nxt or nxt[ops] > val:
                        nxt[ops] = val
                # Option 2: replace val with smallest sorted2[j] > last
                idx = bisect.bisect_right(sorted2, last)
                if idx < len(sorted2):
                    new_ops = ops + 1
                    if new_ops not in nxt or nxt[new_ops] > sorted2[idx]:
                        nxt[new_ops] = sorted2[idx]
            cloned = nxt
            if not cloned:
                return -1

        return min(cloned.keys())
