# https://leetcode.com/problems/minimum-operations-to-halve-array-sum/
class Solution:
    def halveArray(self, nums: List[int]) -> int:
        import heapq
        total = sum(nums)
        target = total / 2.0
        max_heap = [-x for x in nums]
        heapq.heapify(max_heap)
        reduced = 0.0
        ops = 0
        while reduced < target:
            top = -heapq.heappop(max_heap)
            half = top / 2.0
            reduced += half
            heapq.heappush(max_heap, -half)
            ops += 1
        return ops
