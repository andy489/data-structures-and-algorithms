# https://leetcode.com/problems/count-partitions-with-even-sum-difference/
class Solution:
    def countPartitions(self, nums: List[int]) -> int:
        total = sum(nums)
        if total % 2 != 0:
            return 0
        return len(nums) - 1
