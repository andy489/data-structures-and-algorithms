# https://leetcode.com/problems/fancy-sequence/

class Fancy:
    MOD = 10 ** 9 + 7

    def __init__(self):
        self.seq = []
        self.add = 0
        self.mult = 1

    def append(self, val: int) -> None:
        base = (val - self.add) * pow(self.mult, self.MOD - 2, self.MOD) % self.MOD
        self.seq.append(base)

    def addAll(self, inc: int) -> None:
        self.add = (self.add + inc) % self.MOD

    def multAll(self, m: int) -> None:
        self.mult = self.mult * m % self.MOD
        self.add = self.add * m % self.MOD

    def getIndex(self, idx: int) -> int:
        if idx >= len(self.seq):
            return -1
        return (self.seq[idx] * self.mult + self.add) % self.MOD
