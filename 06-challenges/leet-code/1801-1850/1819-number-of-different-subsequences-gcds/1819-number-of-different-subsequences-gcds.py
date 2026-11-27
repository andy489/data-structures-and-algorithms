# https://leetcode.com/problems/number-of-different-subsequences-gcds/

from math import gcd

class Solution:
    def countDifferentSubsequencesGCDs(self, nums: list[int]) -> int:
        max_val = max(nums)
        present = set(nums)
        ans = 0
        for g in range(1, max_val + 1):
            cur = 0
            for multiple in range(g, max_val + 1, g):
                if multiple in present:
                    cur = gcd(cur, multiple)
                    if cur == g:
                        ans += 1
                        break
        return ans
