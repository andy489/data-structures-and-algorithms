# https://leetcode.com/problems/maximum-size-of-a-set-after-removals/

class Solution:
    def maximumSetSize(self, nums1: list[int], nums2: list[int]) -> int:
        s1, s2 = set(nums1), set(nums2)
        n, half = len(nums1), len(nums1) // 2
        only1 = len(s1 - s2)
        only2 = len(s2 - s1)
        shared = len(s1 & s2)
        take1 = min(only1, half)
        take2 = min(only2, half)
        return take1 + take2 + min(shared, n - take1 - take2)
