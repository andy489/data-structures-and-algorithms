# https://leetcode.com/problems/minimum-absolute-sum-difference/

import bisect

class Solution:
    def minAbsoluteSumDiff(self, nums1: list[int], nums2: list[int]) -> int:
        MOD = 10**9 + 7
        sorted1 = sorted(nums1)
        total = 0
        max_save = 0
        for a, b in zip(nums1, nums2):
            diff = abs(a - b)
            total += diff
            pos = bisect.bisect_left(sorted1, b)
            if pos < len(sorted1):
                max_save = max(max_save, diff - abs(sorted1[pos] - b))
            if pos > 0:
                max_save = max(max_save, diff - abs(sorted1[pos - 1] - b))
        return (total - max_save) % MOD
