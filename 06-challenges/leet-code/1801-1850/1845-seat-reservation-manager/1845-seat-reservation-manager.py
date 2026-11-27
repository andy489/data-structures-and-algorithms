# https://leetcode.com/problems/seat-reservation-manager/

import heapq

class SeatManager:
    def __init__(self, n: int):
        self._heap = list(range(1, n + 1))

    def reserve(self) -> int:
        return heapq.heappop(self._heap)

    def unreserve(self, seatNumber: int) -> None:
        heapq.heappush(self._heap, seatNumber)
