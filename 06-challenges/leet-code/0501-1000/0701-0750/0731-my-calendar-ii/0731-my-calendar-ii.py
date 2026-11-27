# https://leetcode.com/problems/my-calendar-ii/

class MyCalendarTwo:
    def __init__(self):
        self.singles = []
        self.doubles = []

    def book(self, start: int, end: int) -> bool:
        for s, e in self.doubles:
            if start < e and end > s:
                return False
        for s, e in self.singles:
            lo, hi = max(s, start), min(e, end)
            if lo < hi:
                self.doubles.append((lo, hi))
        self.singles.append((start, end))
        return True
