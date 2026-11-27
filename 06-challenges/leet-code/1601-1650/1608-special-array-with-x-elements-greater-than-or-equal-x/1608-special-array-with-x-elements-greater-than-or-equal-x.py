# https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

import bisect

class Solution:
    def specialArray(self, nums: list[int]) -> int:
        nums.sort()
        n = len(nums)
        for x in range(1, n + 1):
            idx = bisect.bisect_left(nums, x)
            if n - idx == x:
                return x
        return -1
