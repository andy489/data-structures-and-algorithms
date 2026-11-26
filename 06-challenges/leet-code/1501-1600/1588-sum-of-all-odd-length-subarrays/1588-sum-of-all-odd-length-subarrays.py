# https://leetcode.com/problems/sum-of-all-odd-length-subarrays/

class Solution:
    def sumOddLengthSubarrays(self, arr: list[int]) -> int:
        n = len(arr)
        total = 0
        for i, v in enumerate(arr):
            left, right = i + 1, n - i
            odd_count = (left * right + 1) // 2
            total += v * odd_count
        return total
