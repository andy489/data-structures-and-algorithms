# https://leetcode.com/problems/min-stack/

# Solution 1: Auxiliary min stack — O(1) all ops, O(n) space
class MinStack:
    def __init__(self):
        self.stack: list[int] = []
        self.min_stack: list[int] = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        m = val if not self.min_stack else min(val, self.min_stack[-1])
        self.min_stack.append(m)

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]


# Solution 2: Single stack of (val, min) pairs — O(1) all ops, O(n) space
class MinStack2:
    def __init__(self):
        self.stack: list[tuple[int, int]] = []

    def push(self, val: int) -> None:
        m = val if not self.stack else min(val, self.stack[-1][1])
        self.stack.append((val, m))

    def pop(self) -> None:
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]
