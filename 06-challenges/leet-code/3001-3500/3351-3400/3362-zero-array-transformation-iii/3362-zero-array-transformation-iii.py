# https://leetcode.com/problems/zero-array-transformation-iii/

# Solution: Greedy + Max-Heap (Sweep Line) — O((n + q) log q) time, O(n + q) space
import heapq

class Solution:
    def maxRemoval(self, nums: list[int], queries: list[list[int]]) -> int:
        n = len(nums)
        by_left: list[list[int]] = [[] for _ in range(n + 1)]
        for l, r in queries:
            by_left[l].append(r)

        heap: list[int] = []  # max-heap via negation
        diff = [0] * (n + 1)
        coverage = 0
        used = 0

        for i in range(n):
            coverage += diff[i]
            for r in by_left[i]:
                heapq.heappush(heap, -r)
            while coverage < nums[i]:
                if not heap or -heap[0] < i:
                    return -1
                r = -heapq.heappop(heap)
                diff[i] += 1
                diff[r + 1] -= 1
                coverage += 1
                used += 1

        return len(queries) - used
