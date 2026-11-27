# https://leetcode.com/problems/reverse-linked-list/

# Solution: Iterative — O(n) time, O(1) space
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        prev = None
        curr = head

        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt

        return prev

# Solution 2: Recursive — O(n) time, O(n) space
class Solution2:
    def reverseList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head

        new_head = self.reverseList(head.next)
        head.next.next = head
        head.next = None

        return new_head
