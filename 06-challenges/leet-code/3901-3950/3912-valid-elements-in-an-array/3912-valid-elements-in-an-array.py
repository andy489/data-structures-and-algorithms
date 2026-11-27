# https://leetcode.com/problems/valid-elements-in-an-array/
from typing import List


class Solution:
    def validElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        prefix_max = [float('-inf')] * n
        for i in range(1, n):
            prefix_max[i] = max(prefix_max[i - 1], nums[i - 1])
        suffix_max = [float('-inf')] * n
        for i in range(n - 2, -1, -1):
            suffix_max[i] = max(suffix_max[i + 1], nums[i + 1])
        return [nums[i] for i in range(n) if nums[i] > prefix_max[i] or nums[i] > suffix_max[i]]
