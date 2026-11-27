# https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/

import random
from collections import defaultdict

class RandomizedCollection:
    def __init__(self):
        self.indices: dict[int, set[int]] = defaultdict(set)
        self.vals: list[int] = []

    def insert(self, val: int) -> bool:
        absent = len(self.indices[val]) == 0
        self.indices[val].add(len(self.vals))
        self.vals.append(val)
        return absent

    def remove(self, val: int) -> bool:
        if not self.indices[val]:
            return False
        idx = next(iter(self.indices[val]))
        self.indices[val].discard(idx)
        last = self.vals[-1]
        if idx < len(self.vals) - 1:
            self.vals[idx] = last
            self.indices[last].discard(len(self.vals) - 1)
            self.indices[last].add(idx)
        self.vals.pop()
        return True

    def getRandom(self) -> int:
        return random.choice(self.vals)
