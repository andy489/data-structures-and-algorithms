# https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i/

class Solution:
    def maxOperations(self, nums: list[int]) -> int:
        target = nums[0] + nums[1]
        count = i = 0
        while i + 1 < len(nums) and nums[i] + nums[i+1] == target:
            count += 1
            i += 2
        return count
