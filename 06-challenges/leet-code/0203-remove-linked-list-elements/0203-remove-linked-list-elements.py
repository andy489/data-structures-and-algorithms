# https://leetcode.com/problems/remove-linked-list-elements/

# Solution: Sentinel Node — O(n) time, O(1) space
class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        sentinel = ListNode(0, head)
        curr = sentinel

        while curr.next:
            if curr.next.val == val:
                curr.next = curr.next.next
            else:
                curr = curr.next

        return sentinel.next
