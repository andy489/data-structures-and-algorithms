# https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/
class Solution:
    def minOperations(self, nums: list[int], k: int) -> int:
        xor_all = 0
        for num in nums:
            xor_all ^= num
        return bin(xor_all ^ k).count('1')
