# https://leetcode.com/problems/intersection-of-two-arrays-ii/

class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        cloned = {}
        for n in nums1:
            cloned[n] = cloned.get(n, 0) + 1
        result = []
        for n in nums2:
            if cloned.get(n, 0) > 0:
                result.append(n)
                cloned[n] -= 1
        return result
