# https://leetcode.com/problems/design-an-ordered-stream/

class OrderedStream:
    def __init__(self, n: int):
        self.data = [None] * (n + 1)
        self.ptr = 1

    def insert(self, idKey: int, value: str) -> list[str]:
        self.data[idKey] = value
        result = []
        while self.ptr < len(self.data) and self.data[self.ptr] is not None:
            result.append(self.data[self.ptr])
            self.ptr += 1
        return result
