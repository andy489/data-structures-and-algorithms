# https://leetcode.com/problems/dinner-plate-stacks/

import heapq

class DinnerPlates:
    def __init__(self, capacity: int):
        self.cap = capacity
        self.stacks = []
        self.available = []  # min-heap of indices with space

    def push(self, val: int) -> None:
        # Clean up stale indices
        while self.available and self.available[0] < len(self.stacks) and len(self.stacks[self.available[0]]) >= self.cap:
            heapq.heappop(self.available)
        if not self.available:
            self.stacks.append([])
            heapq.heappush(self.available, len(self.stacks) - 1)
        idx = self.available[0]
        self.stacks[idx].append(val)
        if len(self.stacks[idx]) >= self.cap:
            heapq.heappop(self.available)

    def pop(self) -> int:
        while self.stacks and not self.stacks[-1]:
            self.stacks.pop()
        if not self.stacks:
            return -1
        idx = len(self.stacks) - 1
        val = self.stacks[idx].pop()
        heapq.heappush(self.available, idx)
        while self.stacks and not self.stacks[-1]:
            self.stacks.pop()
        return val

    def popAtStack(self, index: int) -> int:
        if index >= len(self.stacks) or not self.stacks[index]:
            return -1
        val = self.stacks[index].pop()
        heapq.heappush(self.available, index)
        while self.stacks and not self.stacks[-1]:
            self.stacks.pop()
        return val
