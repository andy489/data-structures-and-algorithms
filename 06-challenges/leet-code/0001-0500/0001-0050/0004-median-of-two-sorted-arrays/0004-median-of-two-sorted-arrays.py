# https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution:
    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        n1, n2 = len(nums1), len(nums2)
        lo, hi = 0, n1

        while lo <= hi:
            pivot1 = (lo + hi) // 2
            pivot2 = (n1 + n2 + 1) // 2 - pivot1

            l1 = nums1[pivot1 - 1] if pivot1 > 0 else float('-inf')
            r1 = nums1[pivot1] if pivot1 < n1 else float('inf')
            l2 = nums2[pivot2 - 1] if pivot2 > 0 else float('-inf')
            r2 = nums2[pivot2] if pivot2 < n2 else float('inf')

            if l1 <= r2 and l2 <= r1:
                if (n1 + n2) % 2 == 1:
                    return max(l1, l2)
                return (max(l1, l2) + min(r1, r2)) / 2.0
            elif l1 > r2:
                hi = pivot1 - 1
            else:
                lo = pivot1 + 1

        return -1.0
