# https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/

from math import gcd
from typing import List

class Solution:
    def sumOfGCDPairs(self, nums: List[int]) -> int:
        n = len(nums)
        pg = []
        max_so_far = nums[0]
        for v in nums:
            max_so_far = max(max_so_far, v)
            pg.append(gcd(v, max_so_far))
        pg.sort()
        total = 0
        l, r = 0, n - 1
        while l < r:
            total += gcd(pg[l], pg[r])
            l += 1
            r -= 1
        return total
