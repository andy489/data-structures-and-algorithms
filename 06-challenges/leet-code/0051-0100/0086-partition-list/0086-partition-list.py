# https://leetcode.com/problems/partition-list/

class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        less_dummy = ListNode(0)
        greater_dummy = ListNode(0)
        less, greater = less_dummy, greater_dummy
        curr = head
        while curr:
            if curr.val < x:
                less.next = curr
                less = less.next
            else:
                greater.next = curr
                greater = greater.next
            curr = curr.next
        greater.next = None
        less.next = greater_dummy.next
        return less_dummy.next
