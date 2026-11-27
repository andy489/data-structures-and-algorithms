# https://leetcode.com/problems/tuple-with-same-product/

class Solution:
    def tupleSameProduct(self, nums: list[int]) -> int:
        from collections import defaultdict
        product_count = defaultdict(int)
        n = len(nums)
        for i in range(n):
            for j in range(i + 1, n):
                product_count[nums[i] * nums[j]] += 1
        return sum(c * (c - 1) // 2 * 8 for c in product_count.values())
