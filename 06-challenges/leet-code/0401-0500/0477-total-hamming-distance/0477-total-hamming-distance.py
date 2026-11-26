# https://leetcode.com/problems/total-hamming-distance/

class Solution:
    def totalHammingDistance(self, nums: list[int]) -> int:
        total = 0
        n = len(nums)
        for bit in range(32):
            ones_count = sum((num >> bit) & 1 for num in nums)
            total += ones_count * (n - ones_count)
        return total
