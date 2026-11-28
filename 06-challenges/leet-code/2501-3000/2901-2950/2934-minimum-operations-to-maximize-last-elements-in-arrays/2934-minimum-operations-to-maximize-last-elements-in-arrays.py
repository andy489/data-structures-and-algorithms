# https://leetcode.com/problems/minimum-operations-to-maximize-last-elements-in-arrays/

class Solution:
    def minOperations(self, nums1: list[int], nums2: list[int]) -> int:
        n = len(nums1)
        a, b = nums1[n - 1], nums2[n - 1]

        def count(ta: int, tb: int) -> int:
            swaps = 0
            for i in range(n - 1):
                if nums1[i] <= ta and nums2[i] <= tb:
                    pass
                elif nums2[i] <= ta and nums1[i] <= tb:
                    swaps += 1
                else:
                    return -1
            return swaps

        op1 = count(a, b)
        op2 = count(b, a)
        if op1 == -1 and op2 == -1:
            return -1
        if op1 == -1:
            return op2 + 1
        if op2 == -1:
            return op1
        return min(op1, op2 + 1)
