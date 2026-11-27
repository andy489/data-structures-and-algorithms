# https://leetcode.com/problems/maximize-greatness-of-an-array/
class Solution:
    def maximizeGreatness(self, nums: list[int]) -> int:
        nums.sort()
        p = 0
        for num in nums:
            if num > nums[p]:
                p += 1
        return p
