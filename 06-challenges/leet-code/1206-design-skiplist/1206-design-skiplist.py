# https://leetcode.com/problems/design-skiplist/

import random

class Skiplist:
    MAX_LEVEL = 16
    P = 0.5

    class Node:
        def __init__(self, val, level):
            self.val = val
            self.next = [None] * level

    def __init__(self):
        self.head = self.Node(-1, self.MAX_LEVEL)

    def _random_level(self):
        level = 1
        while random.random() < self.P and level < self.MAX_LEVEL:
            level += 1
        return level

    def search(self, target: int) -> bool:
        cur = self.head
        for i in range(self.MAX_LEVEL-1, -1, -1):
            while cur.next[i] and cur.next[i].val < target:
                cur = cur.next[i]
        return cur.next[0] is not None and cur.next[0].val == target

    def add(self, num: int) -> None:
        update = [None] * self.MAX_LEVEL
        cur = self.head
        for i in range(self.MAX_LEVEL-1, -1, -1):
            while cur.next[i] and cur.next[i].val < num:
                cur = cur.next[i]
            update[i] = cur
        level = self._random_level()
        node = self.Node(num, level)
        for i in range(level):
            node.next[i] = update[i].next[i]
            update[i].next[i] = node

    def erase(self, num: int) -> bool:
        update = [None] * self.MAX_LEVEL
        cur = self.head
        for i in range(self.MAX_LEVEL-1, -1, -1):
            while cur.next[i] and cur.next[i].val < num:
                cur = cur.next[i]
            update[i] = cur
        if not cur.next[0] or cur.next[0].val != num:
            return False
        target = cur.next[0]
        for i in range(self.MAX_LEVEL):
            if update[i].next[i] != target: break
            update[i].next[i] = target.next[i]
        return True
