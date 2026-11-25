# https://leetcode.com/problems/random-pick-with-blacklist/

import random

class Solution:
    def __init__(self, n: int, blacklist: List[int]):
        self.m = n - len(blacklist)
        black_set = set(blacklist)
        self.remap = {}
        ptr = self.m
        for b in blacklist:
            if b < self.m:
                while ptr in black_set:
                    ptr += 1
                self.remap[b] = ptr
                ptr += 1

    def pick(self) -> int:
        r = random.randint(0, self.m - 1)
        return self.remap.get(r, r)
