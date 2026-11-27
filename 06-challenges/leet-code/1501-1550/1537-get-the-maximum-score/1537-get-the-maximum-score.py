# https://leetcode.com/problems/get-the-maximum-score/

class Solution:
    def maxSum(self, nums1: list[int], nums2: list[int]) -> int:
        MOD = 10 ** 9 + 7
        i = j = 0
        sum1 = sum2 = 0
        while i < len(nums1) or j < len(nums2):
            if i < len(nums1) and (j >= len(nums2) or nums1[i] < nums2[j]):
                sum1 += nums1[i]
                i += 1
            elif j < len(nums2) and (i >= len(nums1) or nums2[j] < nums1[i]):
                sum2 += nums2[j]
                j += 1
            else:
                best = max(sum1, sum2) + nums1[i]
                sum1 = sum2 = best
                i += 1
                j += 1
        return max(sum1, sum2) % MOD
