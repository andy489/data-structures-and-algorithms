# https://leetcode.com/problems/reorder-list/

# Solution 1: Find Middle + Reverse + Merge — O(n) time, O(1) space
class Solution:
    def reorderList(self, head: 'Optional[ListNode]') -> None:
        if not head or not head.next:
            return

        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        second = slow.next
        slow.next = None
        second = self._reverse(second)

        first = head
        while second:
            tmp1, tmp2 = first.next, second.next
            first.next = second
            second.next = tmp1
            first, second = tmp1, tmp2

    def _reverse(self, head: 'Optional[ListNode]') -> 'Optional[ListNode]':
        prev, cur = None, head
        while cur:
            nxt = cur.next
            cur.next = prev
            prev, cur = cur, nxt
        return prev


# Solution 2: Deque — O(n) time, O(n) space
from collections import deque

class Solution2:
    def reorderList(self, head: 'Optional[ListNode]') -> None:
        if not head or not head.next:
            return

        dq = deque()
        cur = head
        while cur:
            dq.append(cur)
            cur = cur.next

        dummy = ListNode(0)
        tail = dummy
        front = True
        while dq:
            tail.next = dq.popleft() if front else dq.pop()
            tail = tail.next
            front = not front
        tail.next = None
