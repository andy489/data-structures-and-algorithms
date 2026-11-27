# https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

class Solution:
    def flatten(self, head: 'Node') -> 'Node':
        curr = head
        while curr:
            if curr.child:
                child = curr.child
                nxt = curr.next
                curr.next = child
                child.prev = curr
                curr.child = None
                tail = child
                while tail.next:
                    tail = tail.next
                tail.next = nxt
                if nxt:
                    nxt.prev = tail
            curr = curr.next
        return head
