# https://leetcode.com/problems/all-oone-data-structure/

class AllOne:
    class Bucket:
        def __init__(self, count):
            self.count = count
            self.keys = set()
            self.prev = None
            self.next = None

    def __init__(self):
        self.key_to_bucket = {}
        self.head = AllOne.Bucket(0)
        self.tail = AllOne.Bucket(float('inf'))
        self.head.next = self.tail
        self.tail.prev = self.head

    def _insert_after(self, prev, bucket):
        bucket.prev = prev
        bucket.next = prev.next
        prev.next.prev = bucket
        prev.next = bucket

    def _remove(self, bucket):
        bucket.prev.next = bucket.next
        bucket.next.prev = bucket.prev

    def inc(self, key: str) -> None:
        if key in self.key_to_bucket:
            curr = self.key_to_bucket[key]
            nxt = curr.next
            if nxt.count != curr.count + 1:
                nxt = AllOne.Bucket(curr.count + 1)
                self._insert_after(curr, nxt)
            nxt.keys.add(key)
            self.key_to_bucket[key] = nxt
            curr.keys.discard(key)
            if not curr.keys:
                self._remove(curr)
        else:
            first = self.head.next
            if first.count != 1:
                first = AllOne.Bucket(1)
                self._insert_after(self.head, first)
            first.keys.add(key)
            self.key_to_bucket[key] = first

    def dec(self, key: str) -> None:
        curr = self.key_to_bucket[key]
        if curr.count == 1:
            del self.key_to_bucket[key]
        else:
            prev = curr.prev
            if prev.count != curr.count - 1:
                prev = AllOne.Bucket(curr.count - 1)
                self._insert_after(curr.prev, prev)
            prev.keys.add(key)
            self.key_to_bucket[key] = prev
        curr.keys.discard(key)
        if not curr.keys:
            self._remove(curr)

    def getMaxKey(self) -> str:
        return next(iter(self.tail.prev.keys)) if self.tail.prev != self.head else ""

    def getMinKey(self) -> str:
        return next(iter(self.head.next.keys)) if self.head.next != self.tail else ""
