# https://leetcode.com/problems/exam-room/

import bisect

class ExamRoom:
    def __init__(self, n: int):
        self.n = n
        self.seats = []

    def seat(self) -> int:
        if not self.seats:
            bisect.insort(self.seats, 0)
            return 0
        best_seat, best_dist = 0, self.seats[0]
        for i in range(1, len(self.seats)):
            mid = (self.seats[i] + self.seats[i - 1]) // 2
            dist = mid - self.seats[i - 1]
            if dist > best_dist:
                best_dist = dist
                best_seat = mid
        if self.n - 1 - self.seats[-1] > best_dist:
            best_seat = self.n - 1
        bisect.insort(self.seats, best_seat)
        return best_seat

    def leave(self, p: int) -> None:
        self.seats.remove(p)
