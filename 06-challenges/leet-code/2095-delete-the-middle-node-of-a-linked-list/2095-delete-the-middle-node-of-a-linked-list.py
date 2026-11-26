# https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

class Solution:
    def deleteMiddle(self, head) -> 'ListNode':
        if not head.next:
            return None
        slow, fast = head, head.next.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        slow.next = slow.next.next
        return head
