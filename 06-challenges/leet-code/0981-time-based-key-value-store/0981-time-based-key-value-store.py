# https://leetcode.com/problems/time-based-key-value-store/

import bisect

class TimeMap:
    def __init__(self):
        self.data = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.data:
            self.data[key] = []
        self.data[key].append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.data:
            return ""
        pairs = self.data[key]
        idx = bisect.bisect_right(pairs, (timestamp, chr(127))) - 1
        return pairs[idx][1] if idx >= 0 else ""
