# https://leetcode.com/problems/move-zeroes/

class Solution:
    def moveZeroes(self, nums: list[int]) -> None:
        write = 0
        for num in nums:
            if num != 0:
                nums[write] = num
                write += 1
        while write < len(nums):
            nums[write] = 0
            write += 1
