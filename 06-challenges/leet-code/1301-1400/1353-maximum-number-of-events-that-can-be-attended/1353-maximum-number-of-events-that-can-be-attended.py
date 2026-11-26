# https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/

import heapq

class Solution:
    def maxEvents(self, events: list[list[int]]) -> int:
        events.sort()
        heap = []
        count = i = 0
        n = len(events)
        for day in range(1, 100001):
            while i < n and events[i][0] == day:
                heapq.heappush(heap, events[i][1])
                i += 1
            while heap and heap[0] < day:
                heapq.heappop(heap)
            if heap:
                heapq.heappop(heap)
                count += 1
            if not heap and i == n:
                break
        return count
