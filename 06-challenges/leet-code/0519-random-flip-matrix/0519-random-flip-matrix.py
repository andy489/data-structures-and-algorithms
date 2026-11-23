# https://leetcode.com/problems/random-flip-matrix/

import random

class Solution:
    def __init__(self, m: int, n: int):
        self.m = m
        self.n = n
        self.remaining = m * n
        self.remapped = {}

    def flip(self) -> list[int]:
        self.remaining -= 1
        r = random.randint(0, self.remaining)
        actual = self.remapped.get(r, r)
        self.remapped[r] = self.remapped.get(self.remaining, self.remaining)
        return [actual // self.n, actual % self.n]

    def reset(self) -> None:
        self.remaining = self.m * self.n
        self.remapped.clear()
