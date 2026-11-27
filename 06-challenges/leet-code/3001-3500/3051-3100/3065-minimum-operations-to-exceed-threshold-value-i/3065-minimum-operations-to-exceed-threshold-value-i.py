# https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/

class Solution:
    def minOperations(self, nums: list[int], k: int) -> int:
        return sum(1 for x in nums if x < k)
