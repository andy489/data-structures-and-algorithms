# https://leetcode.com/problems/advantage-shuffle/

class Solution:
    def advantageCount(self, nums1: list[int], nums2: list[int]) -> list[int]:
        nums1.sort()
        idx2 = sorted(range(len(nums2)), key=lambda i: -nums2[i])
        lo, hi = 0, len(nums1) - 1
        result = [0] * len(nums1)
        for i in idx2:
            if nums1[hi] > nums2[i]:
                result[i] = nums1[hi]
                hi -= 1
            else:
                result[i] = nums1[lo]
                lo += 1
        return result
