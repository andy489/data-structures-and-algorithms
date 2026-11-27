# https://leetcode.com/problems/minimum-impossible-or/

# Solution: Check Powers of 2 — O(n) time, O(n) space
class Solution:
    def minImpossibleOR(self, nums: list[int]) -> int:
        nums_set = set(nums)
        power = 1
        while power in nums_set:
            power <<= 1
        return power
