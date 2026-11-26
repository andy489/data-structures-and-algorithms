# https://leetcode.com/problems/sum-of-subsequence-widths/

class Solution:
    def sumSubseqWidths(self, nums: list[int]) -> int:
        MOD = 10**9 + 7
        nums.sort()
        n = len(nums)
        ans = 0
        p = 1
        for i, v in enumerate(nums):
            ans = (ans + v * p - v * pow(2, n - 1 - i, MOD)) % MOD
            p = p * 2 % MOD
        return ans
