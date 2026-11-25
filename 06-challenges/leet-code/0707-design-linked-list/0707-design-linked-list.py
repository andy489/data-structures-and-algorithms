# https://leetcode.com/problems/design-linked-list/

class MyLinkedList:
    class Node:
        def __init__(self, val=0):
            self.val = val
            self.next = None

    def __init__(self):
        self.dummy = self.Node()
        self.tail = self.dummy
        self.size = 0

    def get(self, index: int) -> int:
        if index < 0 or index >= self.size:
            return -1
        curr = self.dummy.next
        for _ in range(index):
            curr = curr.next
        return curr.val

    def addAtHead(self, val: int) -> None:
        node = self.Node(val)
        node.next = self.dummy.next
        self.dummy.next = node
        if self.size == 0:
            self.tail = node
        self.size += 1

    def addAtTail(self, val: int) -> None:
        self.tail.next = self.Node(val)
        self.tail = self.tail.next
        self.size += 1

    def addAtIndex(self, index: int, val: int) -> None:
        if index > self.size:
            return
        if index <= 0:
            self.addAtHead(val)
            return
        if index == self.size:
            self.addAtTail(val)
            return
        prev = self.dummy
        for _ in range(index):
            prev = prev.next
        node = self.Node(val)
        node.next = prev.next
        prev.next = node
        self.size += 1

    def deleteAtIndex(self, index: int) -> None:
        if index < 0 or index >= self.size:
            return
        prev = self.dummy
        for _ in range(index):
            prev = prev.next
        if prev.next == self.tail:
            self.tail = prev
        prev.next = prev.next.next
        self.size -= 1
