# https://leetcode.com/problems/create-maximum-number/

class Solution:
    def maxNumber(self, nums1: list[int], nums2: list[int], k: int) -> list[int]:
        def max_subseq(nums, length):
            stack, drop = [], len(nums) - length
            for n in nums:
                while drop and stack and stack[-1] < n:
                    stack.pop()
                    drop -= 1
                stack.append(n)
            return stack[:length]

        def merge(a, b):
            result = []
            while a or b:
                if a > b:
                    result.append(a[0])
                    a = a[1:]
                else:
                    result.append(b[0])
                    b = b[1:]
            return result

        m, n = len(nums1), len(nums2)
        best = []
        for i in range(max(0, k - n), min(k, m) + 1):
            candidate = merge(max_subseq(nums1, i), max_subseq(nums2, k - i))
            if candidate > best:
                best = candidate
        return best
