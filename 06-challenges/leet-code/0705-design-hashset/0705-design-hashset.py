# https://leetcode.com/problems/design-hashset/

class MyHashSet:
    def __init__(self):
        self.buckets = 769
        self.data = [[] for _ in range(self.buckets)]

    def _hash(self, key: int) -> int:
        return key % self.buckets

    def add(self, key: int) -> None:
        h = self._hash(key)
        if key not in self.data[h]:
            self.data[h].append(key)

    def remove(self, key: int) -> None:
        h = self._hash(key)
        if key in self.data[h]:
            self.data[h].remove(key)

    def contains(self, key: int) -> bool:
        return key in self.data[self._hash(key)]
