# https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/
class Solution:
    def largestPerimeter(self, nums: list[int]) -> int:
        nums.sort()
        prefix_sum = 0
        result = -1
        for num in nums:
            if prefix_sum > num:
                result = prefix_sum + num
            prefix_sum += num
        return result
