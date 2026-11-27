# https://leetcode.com/problems/minimum-increment-to-make-array-unique/

class Solution:
    def minIncrementForUnique(self, nums: list) -> int:
        nums.sort()
        moves = 0
        for i in range(1, len(nums)):
            if nums[i] <= nums[i-1]:
                moves += nums[i-1] + 1 - nums[i]
                nums[i] = nums[i-1] + 1
        return moves
