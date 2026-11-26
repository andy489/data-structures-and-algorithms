# https://leetcode.com/problems/insert-delete-getrandom-o1/

import random

class RandomizedSet:
    def __init__(self):
        self.cloned: dict[int, int] = {}
        self.vals: list[int] = []

    def insert(self, val: int) -> bool:
        if val in self.cloned:
            return False
        self.cloned[val] = len(self.vals)
        self.vals.append(val)
        return True

    def remove(self, val: int) -> bool:
        if val not in self.cloned:
            return False
        idx = self.cloned[val]
        last = self.vals[-1]
        self.vals[idx] = last
        self.cloned[last] = idx
        self.vals.pop()
        del self.cloned[val]
        return True

    def getRandom(self) -> int:
        return random.choice(self.vals)
