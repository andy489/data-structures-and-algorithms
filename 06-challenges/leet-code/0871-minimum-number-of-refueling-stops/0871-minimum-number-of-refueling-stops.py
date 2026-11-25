# https://leetcode.com/problems/minimum-number-of-refueling-stops/

import heapq

class Solution:
    def minRefuelStops(self, target: int, startFuel: int, stations: list[list[int]]) -> int:
        heap = []
        fuel, stops, prev = startFuel, 0, 0
        for pos, cap in stations + [[target, 0]]:
            fuel -= pos - prev
            while fuel < 0 and heap:
                fuel -= heapq.heappop(heap)
                stops += 1
            if fuel < 0:
                return -1
            heapq.heappush(heap, -cap)
            prev = pos
        return stops
