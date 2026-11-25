# https://leetcode.com/problems/design-hashmap/

class MyHashMap:
    def __init__(self):
        self.buckets = 769
        self.data = [[] for _ in range(self.buckets)]

    def _hash(self, key: int) -> int:
        return key % self.buckets

    def put(self, key: int, value: int) -> None:
        h = self._hash(key)
        for pair in self.data[h]:
            if pair[0] == key:
                pair[1] = value
                return
        self.data[h].append([key, value])

    def get(self, key: int) -> int:
        for pair in self.data[self._hash(key)]:
            if pair[0] == key:
                return pair[1]
        return -1

    def remove(self, key: int) -> None:
        h = self._hash(key)
        self.data[h] = [p for p in self.data[h] if p[0] != key]
