# https://leetcode.com/problems/range-module/

from sortedcontainers import SortedList

class RangeModule:
    def __init__(self):
        self.ranges = SortedList(key=lambda x: x[0])

    def addRange(self, left: int, right: int) -> None:
        new_left, new_right = left, right
        to_remove = []
        idx = self.ranges.bisect_left((left,))
        if idx > 0 and self.ranges[idx - 1][1] >= left:
            idx -= 1
        while idx < len(self.ranges) and self.ranges[idx][0] <= right:
            l, r = self.ranges[idx]
            new_left = min(new_left, l)
            new_right = max(new_right, r)
            to_remove.append((l, r))
            idx += 1
        for interval in to_remove:
            self.ranges.remove(interval)
        self.ranges.add((new_left, new_right))

    def queryRange(self, left: int, right: int) -> bool:
        idx = self.ranges.bisect_right((left, float('inf'))) - 1
        if idx < 0:
            return False
        l, r = self.ranges[idx]
        return l <= left and r >= right

    def removeRange(self, left: int, right: int) -> None:
        to_add = []
        to_remove = []
        idx = self.ranges.bisect_left((left,))
        if idx > 0 and self.ranges[idx - 1][1] > left:
            idx -= 1
        while idx < len(self.ranges) and self.ranges[idx][0] < right:
            l, r = self.ranges[idx]
            to_remove.append((l, r))
            if l < left:
                to_add.append((l, left))
            if r > right:
                to_add.append((right, r))
            idx += 1
        for interval in to_remove:
            self.ranges.remove(interval)
        for interval in to_add:
            self.ranges.add(interval)
