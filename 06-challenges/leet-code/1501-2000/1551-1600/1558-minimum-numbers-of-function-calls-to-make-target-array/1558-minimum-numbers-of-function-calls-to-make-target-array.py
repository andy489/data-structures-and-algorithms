# https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/

class Solution:
    def minOperations(self, nums: list[int]) -> int:
        max_bits = 0
        adds = 0
        for x in nums:
            adds += bin(x).count('1')
            bits = x.bit_length()
            max_bits = max(max_bits, bits)
        return adds + (max_bits - 1 if max_bits > 0 else 0)
