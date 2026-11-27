# https://leetcode.com/problems/find-the-smallest-balanced-index/

from typing import List

class Solution:
    def smallestBalancedIndex(self, nums: List[int]) -> int:
        n = len(nums)
        total = sum(nums)
        max_sum = total

        # Build suffix products with overflow guard
        suf_prod = [1] * (n + 1)
        for i in range(n - 1, -1, -1):
            suf_prod[i] = suf_prod[i + 1] * nums[i]
            # Guard: if product exceeds max possible sum, cap it
            if suf_prod[i] > max_sum + 1:
                suf_prod[i] = max_sum + 1

        left_sum = 0
        for i in range(n):
            right_prod = suf_prod[i + 1]
            if left_sum == right_prod:
                return i
            left_sum += nums[i]
        return -1
