# https://leetcode.com/problems/rotate-list/

class Solution:
    def rotateRight(self, head, k: int):
        if not head or not head.next:
            return head
        tail = head
        length = 1
        while tail.next:
            tail = tail.next
            length += 1
        k %= length
        if k == 0:
            return head
        new_tail = head
        for _ in range(length - k - 1):
            new_tail = new_tail.next
        new_head = new_tail.next
        new_tail.next = None
        tail.next = head
        return new_head
