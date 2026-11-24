# https://leetcode.com/problems/maximum-subarray-with-equal-products/

from math import gcd, lcm

class Solution:
    def maxLength(self, nums: list[int]) -> int:
        n = len(nums)
        best = 1
        for i in range(n):
            prod = g = l = nums[i]
            for j in range(i + 1, n):
                prod *= nums[j]
                g = gcd(g, nums[j])
                l = lcm(l, nums[j])
                if prod == l * g:
                    best = max(best, j - i + 1)
                elif prod > l * g:
                    break
        return best
