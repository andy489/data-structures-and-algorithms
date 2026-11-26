# https://leetcode.com/problems/maximum-number-of-eaten-apples/

import heapq

class Solution:
    def eatenApples(self, apples: list[int], days: list[int]) -> int:
        heap = []
        n = len(apples)
        eaten = 0
        i = 0
        while i < n or heap:
            if i < n and apples[i] > 0:
                heapq.heappush(heap, [i + days[i], apples[i]])
            while heap and heap[0][0] <= i:
                heapq.heappop(heap)
            if heap:
                heap[0][1] -= 1
                if heap[0][1] == 0:
                    heapq.heappop(heap)
                eaten += 1
            i += 1
        return eaten
