# https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/

class Solution:
    def minOperations(self, nums: list[int], k: int) -> int:
        import heapq
        heapq.heapify(nums)
        ops = 0
        while nums[0] < k:
            x = heapq.heappop(nums)
            y = heapq.heappop(nums)
            heapq.heappush(nums, x * 2 + y)
            ops += 1
        return ops
