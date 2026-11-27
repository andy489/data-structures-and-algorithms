# https://leetcode.com/problems/find-the-distance-value-between-two-arrays/

import bisect

class Solution:
    def findTheDistanceValue(self, arr1, arr2, d: int) -> int:
        arr2.sort()
        count = 0
        for v in arr1:
            lo = bisect.bisect_left(arr2, v-d)
            hi = bisect.bisect_right(arr2, v+d)
            if lo == hi:
                count += 1
        return count
