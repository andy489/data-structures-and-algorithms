# https://leetcode.com/problems/next-greater-element-i/

class Solution:
    def nextGreaterElement(self, nums1: list, nums2: list) -> list:
        next_greater = {}
        stack = []
        for num in nums2:
            while stack and stack[-1] < num:
                next_greater[stack.pop()] = num
            stack.append(num)
        return [next_greater.get(n, -1) for n in nums1]
