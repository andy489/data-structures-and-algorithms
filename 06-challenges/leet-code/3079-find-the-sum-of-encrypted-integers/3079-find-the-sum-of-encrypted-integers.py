# https://leetcode.com/problems/find-the-sum-of-encrypted-integers/

class Solution:
    def sumOfEncryptedInt(self, nums: list[int]) -> int:
        def encrypt(x):
            s = str(x)
            return int(max(s) * len(s))
        return sum(encrypt(x) for x in nums)
