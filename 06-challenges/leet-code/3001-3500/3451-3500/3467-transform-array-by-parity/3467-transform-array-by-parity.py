# https://leetcode.com/problems/transform-array-by-parity/

class Solution:
    def transformArray(self, nums: list[int]) -> list[int]:
        odd_count = sum(1 for x in nums if x % 2 != 0)
        n = len(nums)
        return [0] * (n - odd_count) + [1] * odd_count
