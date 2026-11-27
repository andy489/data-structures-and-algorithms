# https://leetcode.com/problems/single-threaded-cpu/

import heapq

class Solution:
    def getOrder(self, tasks: list[list[int]]) -> list[int]:
        indexed = sorted(enumerate(tasks), key=lambda x: x[1][0])
        heap = []
        result = []
        time = 0
        i = 0
        while len(result) < len(tasks):
            while i < len(indexed) and indexed[i][1][0] <= time:
                orig, t = indexed[i]
                heapq.heappush(heap, (t[1], orig))
                i += 1
            if not heap:
                time = indexed[i][1][0]
                continue
            proc, orig = heapq.heappop(heap)
            result.append(orig)
            time += proc
        return result
