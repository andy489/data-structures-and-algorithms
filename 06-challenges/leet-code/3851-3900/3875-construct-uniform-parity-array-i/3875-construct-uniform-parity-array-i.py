# https://leetcode.com/problems/construct-uniform-parity-array-i/

class Solution:
    def constructArray(self, nums1: list[int]) -> bool:
        odds = sum(1 for x in nums1 if x % 2 != 0)
        evens = len(nums1) - odds
        all_even = odds == 0 or odds >= 2
        all_odd = evens == 0 or odds >= 1
        return all_even or all_odd
