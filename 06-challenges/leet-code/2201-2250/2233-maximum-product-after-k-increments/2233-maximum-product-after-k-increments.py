# https://leetcode.com/problems/maximum-product-after-k-increments/

import heapq

class Solution:
    def maximumProduct(self, nums: list[int], k: int) -> int:
        MOD = 10 ** 9 + 7
        heapq.heapify(nums)
        for _ in range(k):
            heapq.heapreplace(nums, nums[0] + 1)
        result = 1
        for x in nums:
            result = (result * x) % MOD
        return result
