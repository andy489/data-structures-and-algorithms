# https://leetcode.com/problems/design-a-stack-with-increment-operation/

class CustomStack:
    def __init__(self, maxSize: int):
        self.stack = []
        self.inc = []
        self.max_size = maxSize

    def push(self, x: int) -> None:
        if len(self.stack) < self.max_size:
            self.stack.append(x)
            self.inc.append(0)

    def pop(self) -> int:
        if not self.stack:
            return -1
        add = self.inc.pop()
        if self.inc:
            self.inc[-1] += add
        return self.stack.pop() + add

    def increment(self, k: int, val: int) -> None:
        if self.inc:
            self.inc[min(k, len(self.inc)) - 1] += val
