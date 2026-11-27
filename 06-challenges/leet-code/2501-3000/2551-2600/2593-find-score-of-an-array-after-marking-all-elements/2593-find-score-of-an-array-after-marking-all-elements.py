# https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/
import heapq

class Solution:
    def findScore(self, nums: list[int]) -> int:
        heap = [(v, i) for i, v in enumerate(nums)]
        heapq.heapify(heap)
        marked = [False] * len(nums)
        score = 0
        while heap:
            val, idx = heapq.heappop(heap)
            if marked[idx]:
                continue
            score += val
            marked[idx] = True
            if idx > 0:
                marked[idx - 1] = True
            if idx < len(nums) - 1:
                marked[idx + 1] = True
        return score
