# https://leetcode.com/problems/lru-cache/

# Solution 1: HashMap + doubly-linked list — O(1) time, O(n) space
class LRUCache:
    class _Node:
        def __init__(self, key: int = 0, val: int = 0):
            self.key = key
            self.val = val
            self.prev: 'LRUCache._Node | None' = None
            self.next: 'LRUCache._Node | None' = None

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.size = 0
        self.cloned: dict[int, LRUCache._Node] = {}
        self.head = LRUCache._Node()
        self.tail = LRUCache._Node()
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        node = self.cloned.get(key)
        if node is None:
            return -1
        self._move_to_front(node)
        return node.val

    def put(self, key: int, value: int) -> None:
        node = self.cloned.get(key)
        if node:
            node.val = value
            self._move_to_front(node)
        else:
            node = LRUCache._Node(key, value)
            self.cloned[key] = node
            self._add_after_head(node)
            self.size += 1
            if self.size > self.capacity:
                lru = self.tail.prev
                self._remove(lru)
                del self.cloned[lru.key]
                self.size -= 1

    def _add_after_head(self, node: '_Node') -> None:
        node.next = self.head.next
        node.prev = self.head
        self.head.next.prev = node
        self.head.next = node

    def _remove(self, node: '_Node') -> None:
        node.prev.next = node.next
        node.next.prev = node.prev

    def _move_to_front(self, node: '_Node') -> None:
        self._remove(node)
        self._add_after_head(node)


# Solution 2: OrderedDict — O(1) amortised, O(n) space
from collections import OrderedDict

class LRUCache2:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache: OrderedDict[int, int] = OrderedDict()

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        self.cache.move_to_end(key)
        return self.cache[key]

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.cache.move_to_end(key)
        self.cache[key] = value
        if len(self.cache) > self.capacity:
            self.cache.popitem(last=False)
