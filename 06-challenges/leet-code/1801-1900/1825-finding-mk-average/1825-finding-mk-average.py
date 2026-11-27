# https://leetcode.com/problems/finding-mk-average/

from collections import deque
from sortedcontainers import SortedList

class MKAverage:
    def __init__(self, m: int, k: int):
        self.m = m
        self.k = k
        self.window = deque()
        self.lower = SortedList()
        self.middle = SortedList()
        self.upper = SortedList()
        self.middle_sum = 0

    def _rebalance(self):
        while len(self.lower) > self.k:
            val = self.lower.pop()
            self.middle.add(val)
            self.middle_sum += val
        while len(self.upper) > self.k:
            val = self.upper.pop(0)
            self.middle.add(val)
            self.middle_sum += val
        while self.lower and self.middle and self.lower[-1] > self.middle[0]:
            lo, mi = self.lower.pop(), self.middle.pop(0)
            self.middle_sum -= mi
            self.lower.add(mi)
            self.middle.add(lo)
            self.middle_sum += lo
        while self.upper and self.middle and self.upper[0] < self.middle[-1]:
            up, mi = self.upper.pop(0), self.middle.pop()
            self.middle_sum -= mi
            self.upper.add(mi)
            self.middle.add(up)
            self.middle_sum += up

    def addElement(self, num: int) -> None:
        self.window.append(num)
        if len(self.lower) < self.k:
            self.lower.add(num)
        elif len(self.upper) < self.k:
            self.upper.add(num)
        else:
            self.middle.add(num)
            self.middle_sum += num
        self._rebalance()

        if len(self.window) > self.m:
            old = self.window.popleft()
            if old in self.lower:
                self.lower.remove(old)
            elif old in self.upper:
                self.upper.remove(old)
            else:
                self.middle.remove(old)
                self.middle_sum -= old
            self._rebalance()

    def calculateMKAverage(self) -> int:
        if len(self.window) < self.m:
            return -1
        return self.middle_sum // len(self.middle)
