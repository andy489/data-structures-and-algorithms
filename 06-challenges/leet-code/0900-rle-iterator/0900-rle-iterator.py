# https://leetcode.com/problems/rle-iterator/

class RLEIterator:
    def __init__(self, encoding: list[int]):
        self.enc = encoding
        self.idx = 0

    def next(self, n: int) -> int:
        while self.idx < len(self.enc) and n > self.enc[self.idx]:
            n -= self.enc[self.idx]
            self.idx += 2
        if self.idx >= len(self.enc):
            return -1
        self.enc[self.idx] -= n
        return self.enc[self.idx + 1]
