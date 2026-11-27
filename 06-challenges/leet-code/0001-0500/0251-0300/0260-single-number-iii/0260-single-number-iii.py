# https://leetcode.com/problems/single-number-iii/

class Solution:
    def singleNumber(self, nums: list[int]) -> list[int]:
        xor = 0
        for n in nums:
            xor ^= n
        mask = xor & (-xor)
        a = 0
        for n in nums:
            if n & mask:
                a ^= n
        return [a, xor ^ a]
