# https://leetcode.com/problems/minimum-deletions-to-make-array-beautiful/
class Solution:
    def minDeletion(self, nums: List[int]) -> int:
        deletions = 0
        for i in range(len(nums) - 1):
            if (i - deletions) % 2 == 0 and nums[i] == nums[i + 1]:
                deletions += 1
        if (len(nums) - deletions) % 2 != 0:
            deletions += 1
        return deletions
