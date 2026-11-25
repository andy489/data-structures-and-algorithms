# https://leetcode.com/problems/global-and-local-inversions/

class Solution:
    def isIdealPermutation(self, nums: list[int]) -> bool:
        max_so_far = 0
        for i in range(len(nums) - 2):
            max_so_far = max(max_so_far, nums[i])
            if max_so_far > nums[i + 2]:
                return False
        return True
