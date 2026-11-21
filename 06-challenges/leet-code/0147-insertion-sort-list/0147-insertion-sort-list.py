# https://leetcode.com/problems/insertion-sort-list/

# Solution: Dummy head + scan — O(n^2) time, O(1) space
class Solution:
    def insertionSortList(self, head):
        dummy = ListNode(float('-inf'))
        curr = head
        prev = dummy
        while curr:
            nxt = curr.next
            if curr.val >= prev.val:
                prev.next = curr
                prev = curr
            else:
                p = dummy
                while p.next.val <= curr.val:
                    p = p.next
                curr.next = p.next
                p.next = curr
            curr = nxt
        prev.next = None
        return dummy.next
