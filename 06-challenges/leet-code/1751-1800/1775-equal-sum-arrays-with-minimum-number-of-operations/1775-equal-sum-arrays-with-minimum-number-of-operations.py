# https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations/

class Solution:
    def minOperations(self, nums1: list[int], nums2: list[int]) -> int:
        sum1, sum2 = sum(nums1), sum(nums2)
        if sum1 == sum2:
            return 0
        if sum1 < sum2:
            nums1, nums2 = nums2, nums1
            sum1, sum2 = sum2, sum1
        diff = sum1 - sum2
        gains = [0] * 6
        for x in nums1:
            gains[x - 1] += 1
        for x in nums2:
            gains[6 - x] += 1
        ops = 0
        for g in range(5, 0, -1):
            if diff <= 0:
                break
            use = min(gains[g], (diff + g - 1) // g)
            ops += use
            diff -= use * g
        return ops if diff <= 0 else -1
