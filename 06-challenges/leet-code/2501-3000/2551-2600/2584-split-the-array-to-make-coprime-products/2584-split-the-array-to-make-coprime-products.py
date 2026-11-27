# https://leetcode.com/problems/split-the-array-to-make-coprime-products/

from typing import List

class Solution:
    def findValidSplit(self, nums: List[int]) -> int:
        n = len(nums)
        last_seen = {}

        for i, x in enumerate(nums):
            p = 2
            while p * p <= x:
                if x % p == 0:
                    last_seen[p] = i
                    while x % p == 0:
                        x //= p
                p += 1
            if x > 1:
                last_seen[x] = i

        max_right = 0
        for i in range(n - 1):
            x = nums[i]
            p = 2
            while p * p <= x:
                if x % p == 0:
                    max_right = max(max_right, last_seen[p])
                    while x % p == 0:
                        x //= p
                p += 1
            if x > 1:
                max_right = max(max_right, last_seen[x])
            if max_right == i:
                return i

        return -1
