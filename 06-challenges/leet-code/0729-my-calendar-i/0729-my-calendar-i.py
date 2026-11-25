# https://leetcode.com/problems/my-calendar-i/

from sortedcontainers import SortedList

class MyCalendar:
    def __init__(self):
        self.events = SortedList(key=lambda x: x[0])

    def book(self, startTime: int, endTime: int) -> bool:
        idx = self.events.bisect_left((startTime,))
        if idx < len(self.events) and self.events[idx][0] < endTime:
            return False
        if idx > 0 and self.events[idx - 1][1] > startTime:
            return False
        self.events.add((startTime, endTime))
        return True
