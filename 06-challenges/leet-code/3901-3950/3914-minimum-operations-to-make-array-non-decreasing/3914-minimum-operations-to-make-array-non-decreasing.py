# https://leetcode.com/problems/minimum-operations-to-make-array-non-decreasing/
from typing import List


class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        return sum(max(0, nums[i] - nums[i + 1]) for i in range(len(nums) - 1))
