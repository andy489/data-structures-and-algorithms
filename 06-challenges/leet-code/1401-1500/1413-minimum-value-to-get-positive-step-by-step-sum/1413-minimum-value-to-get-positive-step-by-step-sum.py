# https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/

class Solution:
    def minStartValue(self, nums: list[int]) -> int:
        prefix = min_pre = 0
        for n in nums:
            prefix += n
            min_pre = min(min_pre, prefix)
        return max(1, 1 - min_pre)
