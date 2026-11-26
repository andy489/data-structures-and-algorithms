# https://leetcode.com/problems/middle-of-the-linked-list/

class Solution:
    def middleNode(self, head) -> 'ListNode':
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow
