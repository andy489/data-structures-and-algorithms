# https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/

class Solution:
    def minSwap(self, nums1: list[int], nums2: list[int]) -> int:
        keep, swap = 0, 1
        for i in range(1, len(nums1)):
            new_keep, new_swap = float('inf'), float('inf')
            if nums1[i] > nums1[i - 1] and nums2[i] > nums2[i - 1]:
                new_keep = min(new_keep, keep)
                new_swap = min(new_swap, swap + 1)
            if nums1[i] > nums2[i - 1] and nums2[i] > nums1[i - 1]:
                new_keep = min(new_keep, swap)
                new_swap = min(new_swap, keep + 1)
            keep, swap = new_keep, new_swap
        return min(keep, swap)
