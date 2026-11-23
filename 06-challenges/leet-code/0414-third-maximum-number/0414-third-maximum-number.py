# https://leetcode.com/problems/third-maximum-number/

class Solution:
    def thirdMax(self, nums: list[int]) -> int:
        first = second = third = float('-inf')
        for num in nums:
            if num in (first, second, third):
                continue
            if num > first:
                third, second, first = second, first, num
            elif num > second:
                third, second = second, num
            elif num > third:
                third = num
        return first if third == float('-inf') else third
