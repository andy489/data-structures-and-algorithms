# https://leetcode.com/problems/map-sum-pairs/

class MapSum:
    def __init__(self):
        self.store = {}

    def insert(self, key: str, val: int) -> None:
        self.store[key] = val

    def sum(self, prefix: str) -> int:
        return sum(v for k, v in self.store.items() if k.startswith(prefix))
