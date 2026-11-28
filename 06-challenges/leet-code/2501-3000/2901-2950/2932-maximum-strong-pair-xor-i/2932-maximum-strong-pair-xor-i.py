# https://leetcode.com/problems/maximum-strong-pair-xor-i/

class Solution:
    def maximumStrongPairXor(self, nums: list[int]) -> int:
        ans = 0
        for x in nums:
            for y in nums:
                if abs(x - y) <= min(x, y):
                    ans = max(ans, x ^ y)
        return ans
