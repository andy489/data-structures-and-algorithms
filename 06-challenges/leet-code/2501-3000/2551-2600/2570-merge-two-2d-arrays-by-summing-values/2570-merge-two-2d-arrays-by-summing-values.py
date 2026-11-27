# https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/

# Solution: Two Pointers Merge — O(m + n) time, O(m + n) space
class Solution:
    def mergeArrays(self, nums1: list[list[int]], nums2: list[list[int]]) -> list[list[int]]:
        result = []
        i, j = 0, 0
        while i < len(nums1) and j < len(nums2):
            if nums1[i][0] == nums2[j][0]:
                result.append([nums1[i][0], nums1[i][1] + nums2[j][1]])
                i += 1
                j += 1
            elif nums1[i][0] < nums2[j][0]:
                result.append(nums1[i])
                i += 1
            else:
                result.append(nums2[j])
                j += 1
        result.extend(nums1[i:])
        result.extend(nums2[j:])
        return result
