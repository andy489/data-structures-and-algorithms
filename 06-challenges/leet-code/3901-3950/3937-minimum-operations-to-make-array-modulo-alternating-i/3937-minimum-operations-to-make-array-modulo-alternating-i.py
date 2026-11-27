# https://leetcode.com/problems/minimum-operations-to-make-array-modulo-alternating-i/
class Solution:
    def minimumOperations(self, nums: list[int], k: int) -> int:
        even_freq = [0] * k
        odd_freq = [0] * k
        for i, v in enumerate(nums):
            if i % 2 == 0:
                even_freq[v % k] += 1
            else:
                odd_freq[v % k] += 1
        even_total = (len(nums) + 1) // 2
        odd_total = len(nums) // 2
        min_ops = float('inf')
        for x in range(k):
            for y in range(k):
                if x == y:
                    continue
                cost = (even_total - even_freq[x]) + (odd_total - odd_freq[y])
                min_ops = min(min_ops, cost)
        return min_ops
