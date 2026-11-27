# https://leetcode.com/problems/find-common-elements-between-two-arrays/
class Solution:
    def findIntersectionValues(self, nums1: list[int], nums2: list[int]) -> list[int]:
        set1 = set(nums1)
        set2 = set(nums2)
        answer1 = sum(1 for x in nums1 if x in set2)
        answer2 = sum(1 for x in nums2 if x in set1)
        return [answer1, answer2]
