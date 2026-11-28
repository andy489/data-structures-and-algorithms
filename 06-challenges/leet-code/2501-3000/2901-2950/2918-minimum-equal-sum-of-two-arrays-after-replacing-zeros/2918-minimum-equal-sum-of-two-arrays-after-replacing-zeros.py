# https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/

class Solution:
    def minSum(self, nums1: list[int], nums2: list[int]) -> int:
        sum1 = sum(nums1)
        zeros1 = nums1.count(0)
        sum2 = sum(nums2)
        zeros2 = nums2.count(0)

        min1 = sum1 + zeros1
        min2 = sum2 + zeros2

        if min1 == min2:
            return min1
        if min1 < min2:
            return min2 if zeros1 > 0 else -1
        return min1 if zeros2 > 0 else -1
