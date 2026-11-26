# https://leetcode.com/problems/my-calendar-iii/

from sortedcontainers import SortedDict

class MyCalendarThree:
    def __init__(self):
        self.diff = SortedDict()

    def book(self, startTime: int, endTime: int) -> int:
        self.diff[startTime] = self.diff.get(startTime, 0) + 1
        self.diff[endTime] = self.diff.get(endTime, 0) - 1
        active = max_k = 0
        for delta in self.diff.values():
            active += delta
            max_k = max(max_k, active)
        return max_k
